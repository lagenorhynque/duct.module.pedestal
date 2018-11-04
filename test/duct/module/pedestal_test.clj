(ns duct.module.pedestal-test
  (:require [clojure.test :as t]
            [duct.core :as duct]
            [duct.module.pedestal :as sut]))

(duct/load-hierarchy)

(t/deftest module-test
  (t/testing "environment: production"
    (t/testing "no options"
      (let [config {:duct.core/project-ns 'some-api
                    :duct.core/environment :production
                    :duct.module/pedestal {}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :production
                  :duct.module/pedestal {}
                  :duct.server/pedestal
                  {:service sut/prod-service
                   :default? true
                   :dev? false}}
                 (duct/prep config)))))
    (t/testing "options specified"
      (let [service-map #:io.pedestal.http{:routes #{}
                                           :port 8888}
            config {:duct.core/project-ns 'some-api
                    :duct.core/environment :production
                    :duct.module/pedestal {:service service-map
                                           :default? false
                                           :dev? true}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :production
                  :duct.module/pedestal {:service service-map
                                         :default? false
                                         :dev? true}
                  :duct.server/pedestal
                  {:service (merge sut/prod-service service-map)
                   :default? false
                   :dev? true}}
                 (duct/prep config))))))
  (t/testing "environment: development"
    (t/testing "no options"
      (let [config {:duct.core/project-ns 'some-api
                    :duct.core/environment :development
                    :duct.module/pedestal {}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :development
                  :duct.module/pedestal {}
                  :duct.server/pedestal
                  {:service sut/dev-service
                   :default? true
                   :dev? true}}
                 (duct/prep config)))))
    (t/testing "options specified"
      (let [service-map #:io.pedestal.http{:routes #{}
                                           :port 8888}
            config {:duct.core/project-ns 'some-api
                    :duct.core/environment :development
                    :duct.module/pedestal {:service service-map
                                           :default? false
                                           :dev? false}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :development
                  :duct.module/pedestal {:service service-map
                                         :default? false
                                         :dev? false}
                  :duct.server/pedestal
                  {:service (merge sut/dev-service service-map)
                   :default? false
                   :dev? false}}
                 (duct/prep config)))))))
