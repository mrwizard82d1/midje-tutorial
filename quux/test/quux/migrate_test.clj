(ns quux.migrate-test
  (:require [quux.migrate :as q.m]
            [midje.sweet :refer :all]))

(facts "about migrate"
  (fact "migrate produces new left and right map"
    (q.m/migrate {:a 1} :a {}) => (contains {:new-left {} :new-right {:a 1}})
    (q.m/migrate {:a 1} :b {}) => (contains {:new-left {:a 1} :new-right {}}))
  (fact "migrate handles multiple keys"
    (q.m/migrate {:a 1 :b 2} :a :b {}) => (contains {:new-left {} :new-right {:a 1 :b 2}})))
