(defproject sumap-distances "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [clojure-csv "2.0.0-alpha2"]]
  :main ^:skip-aot sumap-distances.core
  :target-path "target/%s"
  :profiles {
    :dev {:dependencies [
      [com.cemerick/pomegranate "0.3.0"]]}
    :uberjar {:aot :all}})
