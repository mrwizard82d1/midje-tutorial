(ns quux.migrate-test
  (:require [quux.migrate :as q.m]
            [midje.sweet :refer :all]))

(facts "about migrate"
  (fact "migration produces new left and right map"
    (q.m/migrate {:a 1} :a {}) => {:new-left {} :clash #{} :new-right {:a 1}}
    (q.m/migrate {:a 1} :b {}) => {:new-left {:a 1} :clash #{} :new-right {}}))
