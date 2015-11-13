(ns bob
  (:require [clojure.string :as string]))

(defn- remove-punctuation [input]
  (apply str (re-seq #"[a-zA-Z]" input)))

(defn is-question? [input]
  (.endsWith input "?"))

(defn is-silence? [input]
  (string/blank? input))

(defn is-uppercase? [input]
  (let [input-without-punctuation (remove-punctuation input)]
    (and (not-empty input-without-punctuation) (re-matches #"\p{Upper}+" input-without-punctuation))))

(defn response-for [input]
  (cond
    (is-silence? input) "Fine. Be that way!"
    (is-uppercase? input) "Whoa, chill out!"
    (is-question? input) "Sure."
    :default "Whatever."))
