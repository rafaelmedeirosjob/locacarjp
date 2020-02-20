import axios from 'axios'
import config from '../config/uri.js'

export default {
  request (method, uri, data = null) {
    if (!method) {
      return
    }

    if (!uri) {
      return
    }
    var url = config.serverURI + uri
    return axios({ method, url, data })
  }
}
