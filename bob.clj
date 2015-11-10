(ns bob)

(defn- remove-punctuation [input]
  (apply str (re-seq #"[a-zA-Z]" input)))

(defn input-is-question? [input]
  (= (.indexOf input "?") (- (.length input) 1)))

(defn input-is-silence? [input]
  (or (empty? input) (re-matches #"\s+" input)))

(defn response-for [input]
  (let [input-without-punctuation (remove-punctuation input)]
    (if (input-is-silence? input)
      "Fine. Be that way!"
      (if (every? #(Character/isUpperCase %) input-without-punctuation)
        "Whoa, chill out!"
        (if (input-is-question? input)
          "Sure."
          "Whatever.")))))
