(ns quux.migrate)

(def migrate
  (fn [left key right]
    {:new-left (dissoc left key) 
     :clash #{} 
     :new-right (if-let [left-value (left key)]
                  (assoc right key left-value)
                  right)}))
