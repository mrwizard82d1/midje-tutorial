(ns quux.migrate)

(def migrate
  (fn [left key right]
    {:new-left (dissoc left key) 
     :clashes #{}
     :new-right (if-let [left-value (left key)]
                  (assoc right key left-value)
                  right)}))
