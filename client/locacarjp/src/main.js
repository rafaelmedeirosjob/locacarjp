import Vue from 'vue'

// Components
import './components'

// Plugins
import './plugins'
import { sync } from 'vuex-router-sync'

// Application imports
import App from './App'
import router from '@/router'
import store from '@/store'
import VueTheMask from 'vue-the-mask'
import money from 'v-money'
import moment from 'moment'
import DatetimePicker from 'vuetify-datetime-picker'
// Sync store with router
sync(store, router)
Vue.use(DatetimePicker)
Vue.use(moment)
Vue.use(money, { precision: 4 })
Vue.use(VueTheMask)
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
