(ns bob)

(defn- remove-punctuation [input]
  (apply str (re-seq #"[a-zA-Z]" input)))

(defn response-for [input]
 (let [input-without-punctuation (remove-punctuation input)]
  (if (every? #(Character/isUpperCase %) input-without-punctuation)
   "Whoa, chill out!"
   "Whatever.")))
