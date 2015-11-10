(ns bob)

(defn- remove-punctuation [input]
  (apply str (re-seq #"[a-zA-Z]" input)))

(defn input-is-question? [input]
  (= (.indexOf input "?") (- (.length input) 1)))

(defn input-is-silence? [input]
  (or (empty? input) (re-matches #"\s+" input)))

(defn input-is-uppercase? [input]
  (let [input-without-punctuation (remove-punctuation input)]
    (and (not-empty input-without-punctuation) (re-matches #"\p{Upper}+" input-without-punctuation))))

(defn response-for [input]
  (if (input-is-silence? input)
    "Fine. Be that way!"
    (if (input-is-uppercase? input)
      "Whoa, chill out!"
      (if (input-is-question? input)
        "Sure."
        "Whatever."))))
