(ns app.core
  (:require [helix.core :refer [defnc $]]
            [helix.hooks :as hooks]
            [helix.dom :as d]
            [shadow.css :refer [css]]
            ["react-dom/client" :as rdom]))

;; define components using the `defnc` macro
(defnc greeting
  "A component which greets a user."
  [{:keys [name]}]
  ;; use helix.dom to create DOM elements
  (d/div {:class-name (css :text-sky-500)}
   "Hello, " (d/strong name) "!"))

(defnc app []
  {:helix/features {:fast-refresh true}}
  (let [[state set-state] (hooks/use-state {:name "Helix User"})]
    (d/div {:class-name (css :bg-slate-900 :h-screen :flex :flex-col :items-center :pt-64)}

     (d/h1 {:class-name (css :text-white :text-4xl :font-bold)} "Welcome to your reactive clojurescript dev setup!")

     (d/div {:class-name (css :w-sm :h-sm :mt-12)}
         (d/img {:src "resources/React-icon.png"}))

     (d/p {:class-name (css :text-white :text-lg)} "Edit src/main/app/core.cljs and save to reload")
     (d/h2 {:class-name (css :text-white :text-lg)} "this setup uses shadow-cljs, shadow-css, and helix")
     ;; create elements out of components
     (d/br)
     ($ greeting {:name (:name state)})
     (d/input {:value (:name state)
               :on-change #(set-state assoc :name (.. % -target -value))}))))

;; start your app with your favorite React renderer
(defn ^:export init []
  (let [root (rdom/createRoot (js/document.getElementById "root"))]
    (.render root ($ app))))
