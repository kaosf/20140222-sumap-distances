(ns sumap-distances.core
  (:import [java.net URLEncoder])
  (:require [clojure-csv.core :refer (parse-csv)]
            [clj-http.client :as http]
            [clojure.xml :as xml]
            [clojure.string :refer (split)])
  (:gen-class))

(def addresses
  (->
    (slurp "inputdata.csv")
    parse-csv
    ;rest
    vec))

(defn retrieve-lat-lon [address]
  (let [key ""
        pflg "2"
        outf "TSV"
        datum "WGS84"
        frewd (URLEncoder/encode address)
        url (str "http://test.cgi.e-map.ne.jp/cgi/selectaddr.cgi?key=" key "&enc=UTF8&pflg=" pflg "&mclv=3&sep=1&outf=" outf "&datum=" datum "&frewd=" frewd)
        body ((http/get url) :body)
        [_ _ _ _ _ lat lon] (split ((split body #"\r\n") 1) #"\t")]
    [lat lon]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
