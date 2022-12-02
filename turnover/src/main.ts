import { createApp } from 'vue'
import { createPinia } from 'pinia';

import './style.css'
import App from '@/App.vue';
import router from "./router";
import stores from "./store";

import DashboardLayout from './components/DashboardLayout.vue';
import EmptyLayout from './components/EmptyLayout.vue';

const pinia = createPinia();
const app = createApp(App);

app.component('default-layout', DashboardLayout);
app.component('empty-layout', EmptyLayout);

app.config.globalProperties.$store = stores; // [store / 저장소]
;
app.use(router);
app.use(pinia)
app.use(stores);
app.mount('#app');
