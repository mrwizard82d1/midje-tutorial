(ns quux.migrate-test
  (:require [quux.migrate :as q.m]
            [midje.sweet :refer :all]))

(facts "about migrate"
  (fact "migrate produces new left and right map"
    (q.m/migrate {:a 1} :a {}) => {:new-left {} :clashes #{} :new-right {:a 1}}
    (q.m/migrate {:a 1} :b {}) => {:new-left {:a 1} :clashes #{} :new-right {}})
  (fact "migrate handles multiple keys"
    (q.m/migrate {:a 1 :b 2} :a :b {}) =>
      {:new-left {} :clashes #{} :new-right {:a 1 :b 2}}))
