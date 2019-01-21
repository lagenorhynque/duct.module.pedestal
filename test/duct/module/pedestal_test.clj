(ns duct.module.pedestal-test
  (:require [clojure.test :as t]
            [duct.core :as duct]
            [duct.module.pedestal :as sut]))

(duct/load-hierarchy)

(t/deftest module-test
  (t/testing "environment: production"
    (t/testing "no options"
      (let [config {:duct.profile/base
                    {:duct.core/project-ns 'some-api}
                    :duct.profile/prod {}
                    :duct.module/pedestal {}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :production
                  :duct.server/pedestal
                  {:base-service sut/prod-service
                   :default? true
                   :dev? false}}
                 (duct/prep-config config)))))
    (t/testing "options specified"
      (let [service-map #:io.pedestal.http{:routes #{}
                                           :port 8888}
            config {:duct.profile/base
                    {:duct.core/project-ns 'some-api
                     :duct.server/pedestal {:service service-map}}
                    :duct.profile/prod {}
                    :duct.module/pedestal {:default? false
                                           :dev? true}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :production
                  :duct.server/pedestal
                  {:service service-map
                   :base-service sut/prod-service
                   :default? false
                   :dev? true}}
                 (duct/prep-config config))))))
  (t/testing "environment: development"
    (t/testing "no options"
      (let [config {:duct.profile/dev {}
                    :duct.profile/base
                    {:duct.core/project-ns 'some-api}
                    :duct.module/pedestal {}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :development
                  :duct.server/pedestal
                  {:base-service sut/dev-service
                   :default? true
                   :dev? true}}
                 (duct/prep-config config [:duct.profile/dev])))))
    (t/testing "options specified"
      (let [service-map #:io.pedestal.http{:routes #{}
                                           :port 8888}
            config {:duct.profile/dev {}
                    :duct.profile/base
                    {:duct.core/project-ns 'some-api
                     :duct.server/pedestal {:service service-map}}
                    :duct.module/pedestal {:default? false
                                           :dev? false}}]
        (t/is (= {:duct.core/project-ns 'some-api
                  :duct.core/environment :development
                  :duct.server/pedestal
                  {:service service-map
                   :base-service sut/dev-service
                   :default? false
                   :dev? false}}
                 (duct/prep-config config)))))))
