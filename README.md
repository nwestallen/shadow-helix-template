# Shadow Helix Template
This is a template for building web-apps using clojurescript and React

## Quick Start
1. Run `npm i`
2. Start dev repl: `npx shadow-cljs run repl/start`
3. Make changes to source files and save to hot reload
4. Release build: `npx shadow-cljs release app`

## Stack details
* [helix](https://github.com/lilactown/helix) as a React wrapper
* [shadow-cljs](https://github.com/thheller/shadow-cljs) to manage builds
* [shadow-css](https://github.com/thheller/shadow-css) for inline stying (tailwind utility class syntax)
* Uses deps.edn for clojure(script) dependencies
* JS dependencies handled via npm/package.json

