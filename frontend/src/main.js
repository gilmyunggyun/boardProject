/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

// Components
import App from './App.vue'

// Composables
import { createApp } from 'vue'

// Plugins
import { registerPlugins } from '@/plugins'

import store from "./store";
import router from "./router";
import "./assets/css/nucleo-icons.css";
import "./assets/css/nucleo-svg.css";

import SoftUIDashboard from "./soft-ui-dashboard";

const app = createApp(App)
    .use(store)
    .use(router)
    .use(SoftUIDashboard)

registerPlugins(app)

app.mount('#app')
