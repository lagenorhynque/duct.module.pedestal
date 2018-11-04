(ns duct.server.pedestal
  (:require [integrant.core :as ig]
            [io.pedestal.http :as http]))

(defmethod ig/init-key :duct.server/pedestal
  [_ {:keys [service base-service default? dev?]}]
  (println (str "\nCreating your " (when dev? "[DEV] ") "server..."))
  (cond-> (merge base-service service)
    ;; Wire up interceptor chains
    default? http/default-interceptors
    dev? http/dev-interceptors
    true http/create-server
    true http/start))

(defmethod ig/halt-key! :duct.server/pedestal
  [_ server]
  (http/stop server))
