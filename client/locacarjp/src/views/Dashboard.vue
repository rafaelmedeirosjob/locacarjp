<template>
  <v-container
    fill-height
    fluid
    grid-list-xl
  >
    <v-layout wrap>
      <v-flex
        md12
        sm12
        lg4
      >
        <material-chart-card
          :data="dailySalesChart.data"
          :options="dailySalesChart.options"
          color="info"
          type="Line"
        >
          <h4 class="title font-weight-light">Alguéis semanalmente</h4>
          <p class="category d-inline-flex font-weight-light">
            <v-icon
              color="green"
              small
            >
              mdi-arrow-up
            </v-icon>
            <span class="green--text">55%</span>&nbsp;
            aumento no total de aluguéis
          </p>

          <template slot="actions">
            <v-icon
              class="mr-2"
              small
            >
              mdi-clock-outline
            </v-icon>
            <span class="caption grey--text font-weight-light">Atualizado a 2 horas atrás</span>
          </template>
        </material-chart-card>
      </v-flex>
      <v-flex
        md12
        sm12
        lg4
      >
        <material-chart-card
          :data="emailsSubscriptionChart.data"
          :options="emailsSubscriptionChart.options"
          :responsive-options="emailsSubscriptionChart.responsiveOptions"
          color="red"
          type="Bar"
        >
          <h4 class="title font-weight-light">Aluguéis mensalmente</h4>
          <p class="category d-inline-flex font-weight-light">2019</p>

          <template slot="actions">
            <v-icon
              class="mr-2"
              small
            >
              mdi-clock-outline
            </v-icon>
            <span class="caption grey--text font-weight-light">Atualizado a 2 horas atrás</span>
          </template>
        </material-chart-card>
      </v-flex>
      <v-flex
        md12
        sm12
        lg4
      >
        <material-chart-card
          :data="dataCompletedTasksChart.data"
          :options="dataCompletedTasksChart.options"
          color="green"
          type="Line"
        >
          <h3 class="title font-weight-light">Horários de devolução</h3>
          <p class="category d-inline-flex font-weight-light">2019</p>

          <template slot="actions">
            <v-icon
              class="mr-2"
              small
            >
              mdi-clock-outline
            </v-icon>
            <span class="caption grey--text font-weight-light">Atualizado a 2 horas atrás</span>
          </template>
        </material-chart-card>
      </v-flex>
      <v-flex
        sm6
        xs12
        md6
        lg3
      >
        <material-stats-card
          color="green"
          icon="mdi-alarm-snooze"
          title="Reservas"
          value="3"
          sub-icon="mdi-calendar"
          sub-text="Last 24 Hours"
        />
      </v-flex>
      <v-flex
        sm6
        xs12
        md6
        lg3
      >
        <material-stats-card
          color="orange"
          icon="mdi-account-heart"
          title="Aluguéis"
          value="0"
          sub-icon="mdi-calendar"
          sub-text="Last 24 Hours"
        />
      </v-flex>
      <v-flex
        sm6
        xs12
        md6
        lg3
      >
        <material-stats-card
          color="red"
          icon="mdi-account-off"
          title="Cancelados"
          value="5"
          sub-icon="mdi-calendar"
          sub-text="Last 24 Hours"
        />
      </v-flex>
      <v-flex
        sm6
        xs12
        md6
        lg3
      >
        <material-stats-card
          color="info"
          icon="mdi-arrow-bottom-left-thick"
          title="Devolvidos"
          value="1"
          sub-icon="mdi-calendar"
          sub-text="Last 24 Hours"
        />
      </v-flex>
      <v-flex
        md12
        lg6
      >
        <material-card
          color="info"
          title="Devoluções"
          text="carros a serem devolvidos nos próximos 7 dias"
        >
          <v-data-table
            :headers="headers"
            :items="devolutions"
            hide-actions
          >
            <template
              slot="headerCell"
              slot-scope="{ header }"
            >
              <span
                class="font-weight-light text-sucess text--darken-3"
                v-text="header.text"
              />
            </template>
            <template
              slot="items"
              slot-scope="{ index, item }"
            >
              <td>{{ item.client.name }}</td>
              <td>{{ item.rentalDate | formatDate}}</td>
              <td>{{ item.rentalDue | formatDate}}</td>
              <td >R$ {{ item.value }}</td>
            </template>
          </v-data-table>
        </material-card>
      </v-flex>
      <v-flex
        md12
        lg6
      >
      <material-card
          color="green"
          title="Recents"
          text="carros alugados à 7 dias atrás"
        >
          <v-data-table
            :headers="headers"
            :items="recents"
            hide-actions
          >
            <template
              slot="headerCell"
              slot-scope="{ header }"
            >
              <span
                class="font-weight-light text-sucess text--darken-3"
                v-text="header.text"
              />
            </template>
            <template
              slot="items"
              slot-scope="{ index, item }"
            >
              <td>{{ item.client.name }}</td>
              <td>{{ item.rentalDate | formatDate}}</td>
              <td>{{ item.rentalDue | formatDate}}</td>
              <td >R$ {{ item.value }}</td>
            </template>
          </v-data-table>
        </material-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import send from "../utils/request.js";
import moment from "moment";
export default {
  data () {
    return {
      dailySalesChart: {
        data: {
          labels: ['M', 'T', 'W', 'T', 'F', 'S', 'S'],
          series: [
            [12, 17, 7, 17, 23, 18, 38]
          ]
        },
        options: {
          lineSmooth: this.$chartist.Interpolation.cardinal({
            tension: 0
          }),
          low: 0,
          high: 50, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
          chartPadding: {
            top: 0,
            right: 0,
            bottom: 0,
            left: 0
          }
        }
      },
      dataCompletedTasksChart: {
        data: {
          labels: ['12am', '3pm', '6pm', '9pm', '12pm', '3am', '6am', '9am'],
          series: [
            [230, 750, 450, 300, 280, 240, 200, 190]
          ]
        },
        options: {
          lineSmooth: this.$chartist.Interpolation.cardinal({
            tension: 0
          }),
          low: 0,
          high: 1000, // creative tim: we recommend you to set the high sa the biggest value + something for a better look
          chartPadding: {
            top: 0,
            right: 0,
            bottom: 0,
            left: 0
          }
        }
      },
      emailsSubscriptionChart: {
        data: {
          labels: ['Ja', 'Fe', 'Ma', 'Ap', 'Mai', 'Ju', 'Jul', 'Au', 'Se', 'Oc', 'No', 'De'],
          series: [
            [542, 443, 320, 780, 553, 453, 326, 434, 568, 610, 756, 895]

          ]
        },
        options: {
          axisX: {
            showGrid: false
          },
          low: 0,
          high: 1000,
          chartPadding: {
            top: 0,
            right: 5,
            bottom: 0,
            left: 0
          }
        },
        responsiveOptions: [
          ['screen and (max-width: 640px)', {
            seriesBarDistance: 5,
            axisX: {
              labelInterpolationFnc: function (value) {
                return value[0]
              }
            }
          }]
        ]
      },
      headers: [
      {
        sortable: true,
        text: 'Nome do cliente',
        value: 'name'
      },
      {
        sortable: true,
        text: 'De',
        value: 'rentalDate'
      },
      {
        sortable: true,
        text: 'Até',
        value: 'rentalDue'
      },
      {
        sortable: true,
        text: 'Valor',
        value: 'value'
      }
    ],
      recents: [],
      devolutions: [],
      tabs: 0,
      list: {
        0: false,
        1: false,
        2: false
      }
    }
  },
  created() {
    this.getDevolutions(0)
    this.getRecents(0)
  },
  filters: {
    formatDate: function(value) {
      if (!value) return ""
      return moment(String(value)).format("DD/MM/YYYY HH:ss")
    }
  },
  methods: {
    complete (index) {
      this.list[index] = !this.list[index]
    },
    getDevolutions(page) {
      send
        .request("get", "rents/devolutions?"+"page="+ page)
        .then(response => {
          
          this.devolutions = response.data.content;
        })
        .catch(error => {
          console.log(error)
        });
    },
     getRecents(page) {
      send
        .request("get", "rents/recents?"+"page="+ page)
        .then(response => {
          
          this.recents = response.data.content;
        })
        .catch(error => {
          console.log(error)
        });
    },
  }
}
</script>
