(ns duct.module.pedestal
  (:require [duct.core :as duct]
            [integrant.core :as ig]
            [io.pedestal.http :as http]))

(defn- get-environment [config options]
  (get options :environment (:duct.core/environment config :production)))

(def prod-service
  {:env :prod
   ;; You can bring your own non-default interceptors. Make
   ;; sure you include routing and set it up right for
   ;; dev-mode. If you do, many other keys for configuring
   ;; default interceptors will be ignored.
   ;; ::http/interceptors []
   ;; ::http/routes routes

   ;; Uncomment next line to enable CORS support, add
   ;; string(s) specifying scheme, host and port for
   ;; allowed source(s):
   ;;
   ;; "http://localhost:8080"
   ;;
   ;;::http/allowed-origins ["scheme://host:port"]

   ;; Tune the Secure Headers
   ;; and specifically the Content Security Policy appropriate to your service/application
   ;; For more information, see: https://content-security-policy.com/
   ;;   See also: https://github.com/pedestal/pedestal/issues/499
   ;;::http/secure-headers {:content-security-policy-settings {:object-src "'none'"
   ;;                                                          :script-src "'unsafe-inline' 'unsafe-eval' 'strict-dynamic' https: http:"
   ;;                                                          :frame-ancestors "'none'"}}

   ;; Root for resource interceptor that is available by default.
   ::http/resource-path "/public"

   ;; Either :jetty, :immutant or :tomcat (see comments in project.clj)
   ;;  This can also be your own chain provider/server-fn -- http://pedestal.io/reference/architecture-overview#_chain_provider
   ::http/type :jetty
   ;;::http/host "localhost"
   ::http/port 8080
   ;; Options to pass to the container (Jetty)
   ::http/container-options {:h2c? true
                             :h2? false
                                        ;:keystore "test/hp/keystore.jks"
                                        ;:key-password "password"
                                        ;:ssl-port 8443
                             :ssl? false}})

(def dev-service
  (merge prod-service
         {:env :dev
          ;; do not block thread that starts web server
          ::http/join? false
          ;; Routes can be a function that resolve routes,
          ;;  we can use this to set the routes to be reloadable
          ;; ::http/routes #(route/expand-routes (deref #'service/routes))
          ;; all origins are allowed in dev mode
          ::http/allowed-origins {:creds true :allowed-origins (constantly true)}
          ;; Content Security Policy (CSP) is mostly turned off in dev mode
          ::http/secure-headers {:content-security-policy-settings {:object-src "'none'"}}}))

(def default-service
  {:production prod-service
   :development dev-service})

(defmethod ig/init-key :duct.module/pedestal
  [_ {:keys [service default? dev?]
      :or {default? true}
      :as options}]
  {:req #{}
   :fn (fn [config]
         (let [environment (get-environment config options)]
           (duct/merge-configs
            config
            {:duct.server/pedestal {:service (merge (get default-service environment)
                                                    service)
                                    :default? default?
                                    :dev? (if (some? dev?) dev? (= environment :development))}})))})
