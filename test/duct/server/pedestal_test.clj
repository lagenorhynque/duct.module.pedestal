(ns duct.server.pedestal-test
  (:require [clojure.test :as t]
            [duct.core :as duct]
            [integrant.core :as ig]
            [io.pedestal.http.route :as route]
            [io.pedestal.test :refer [response-for]]))

(duct/load-hierarchy)

;; example handler
(defn respond-hello [request]
  {:status 200
   :body "Hello, world!"})

;; example routes
(def routes (route/expand-routes
             #{["/greet" :get respond-hello :route-name :greet]}))

;; example service map
(def service-map #:io.pedestal.http{:routes routes})

(def url-for (route/url-for-routes routes))

(defn service-fn
  [system]
  (get-in system [:duct.server/pedestal :io.pedestal.http/service-fn]))

(defmacro with-system
  [[bound-var binding-expr] & body]
  `(let [~bound-var (ig/init ~binding-expr)]
     (try
       ~@body
       (finally
         (ig/halt! ~bound-var)))))

(t/deftest server-test
  (let [config {:duct.core/project-ns 'some-api
                :duct.core/environment :development
                :duct.module/pedestal {:service service-map}}]
    (with-system [sys (duct/prep config)]
      (let [service (service-fn sys)
            {:keys [status body]} (response-for service
                                                :get
                                                (url-for :greet))]
        (t/is (= 200 status))
        (t/is (= "Hello, world!" body))))))
