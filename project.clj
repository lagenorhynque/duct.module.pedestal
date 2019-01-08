(defproject duct.module.pedestal "2.0.0"
  :description "Duct module for Pedestal"
  :url "https://github.com/lagenorhynque/duct.module.pedestal"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.8.1"
  :dependencies [;; Duct
                 [duct/core "0.7.0"]

                 ;; Pedestal
                 [io.pedestal/pedestal.service "0.5.5"]

                 ;; Pedestal server adapter
                 ;; Remove this line and uncomment one of the next lines to
                 ;; use Immutant or Tomcat instead of Jetty:
                 [io.pedestal/pedestal.jetty "0.5.5"]
                 ;; [io.pedestal/pedestal.immutant "0.5.5"]
                 ;; [io.pedestal/pedestal.tomcat "0.5.5"]

                 ;; logging
                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jcl-over-slf4j "1.7.25"]
                 [org.slf4j/jul-to-slf4j "1.7.25"]
                 [org.slf4j/log4j-over-slf4j "1.7.25"]]
  :deploy-repositories [["releases" :clojars]]
  :profiles {:dev {:dependencies [[org.clojure/clojure "1.10.0"]
                                  [pjstadig/humane-test-output "0.9.0"]]
                   :plugins [[jonase/eastwood "0.3.4"]
                             [lein-cljfmt "0.6.3"]
                             [lein-cloverage "1.0.13"]
                             [lein-kibit "0.1.6"]]
                   :aliases {"test-coverage" ^{:doc "Execute cloverage."}
                             ["with-profile" "test" "cloverage" "--codecov" "--junit"]
                             "lint" ^{:doc "Execute cljfmt check, eastwood and kibit."}
                             ["do" ["cljfmt" "check"] ["eastwood"] ["kibit"]]}
                   :injections [(require 'pjstadig.humane-test-output)
                                (pjstadig.humane-test-output/activate!)]}})
