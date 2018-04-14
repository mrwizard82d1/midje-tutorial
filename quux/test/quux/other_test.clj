(ns quux.other-test
  (:require [midje.sweet :refer :all]))

(println "Testing checkers")

;; Although this form works, ...
(fact (+ 1 2) even?)
;; ... as does this form, ...
(fact (some even? [1 5]) => nil)
;; ... these forms are more expressive.
(fact (some even? [1 5]) => falsey)

;; Negating a check
(fact (some even? [1 5]) =not=> truthy)

;; We can use extended equality to write code the way people speak, ...
(fact
  [1 3 5 8] => #(some even? %)
  [1 3 5 8] => (partial some even?))
;; ... but Midje provides checkers to make it even more obvious
(fact [1 3 5 8] => (contains even?))

;; (do
;;   (println "Two expected failures")
;;   (fact {:a 1 :b 2} => (just {:a 1 :CCC 333}))
;;   (fact [1 2 3 4 5] => (contains [1 2 4])))

;; But allowing gaps succeeds
(fact [1 2 3 4 5] => (contains [1 2 4] :gaps-ok))


