(ns bob-test
  (:require [clojure.test :refer :all]
            [bob :refer :all])
  (:use midje.sweet))

(fact "responds-to-something"
      (response-for "Tom-ay-to, tom-aaaah-to.") => "Whatever.")

(future-fact "responds-to-shouts"
      (response-for "WATCH OUT!") => "Whoa, chill out!")

(future-fact "responds-to-questions"
      (response-for "Does this cryogenic chamber make me look fat?") => "Sure.")

(future-fact "responds-to-forceful-talking"
      (response-for "Let's go make out behind the gym!") => "Whatever.")

(future-fact "responds-to-acronyms"
      (response-for "It's OK if you don't want to go to the DMV.") => "Whatever.")

(future-fact "responds-to-forceful-questions"
      (response-for "WHAT THE HELL WERE YOU THINKING?") => "Whoa, chill out!")

(future-fact "responds-to-shouting-with-special-characters"
      (response-for "ZOMG THE %^*@#$(*^ ZOMBIES ARE COMING!!11!!1!") => "Whoa, chill out!")

(future-fact "responds-to-shouting-numbers"
      (response-for "1, 2, 3 GO!") => "Whoa, chill out!")

(future-fact "responds-to-shouting-with-no-exclamation-mark"
      (response-for "I HATE YOU") => "Whoa, chill out!")

(future-fact "responds-to-statement-containing-question-mark"
      (response-for "Ending with ? means a question.") => "Whatever.")

(future-fact "responds-to-silence"
      (response-for "") => "Fine. Be that way!")

(future-fact "responds-to-prolonged-silence"
      (response-for "    ") => "Fine. Be that way!")

(future-fact "responds-to-only-numbers"
      (response-for "1, 2, 3") => "Whatever.")

(future-fact "responds-to-number-question"
      (response-for "4?") => "Sure.")