<template>
  <v-container
    fill-height
    fluid
    grid-list-xl
  >
    <v-layout
      justify-center
      wrap
    >
      <v-flex
        md12
      >
        <material-card
          color="green"
          title="Aluguéis"
        >
          <v-data-table
            :headers="headers"
            :items="rents"
            hide-actions
          >
            <template
              slot="headerCell"
              slot-scope="{ header }"
            >
              <span
                class="subheading font-weight-light text-success text--darken-3"
                v-text="header.text"
              />
            </template>
            <template
              slot="items"
              slot-scope="{ item }"
            >
              <td>{{ item.client.name }}</td>
              <td>{{ item.rentalDate | formatDate}}</td>
              <td>{{ item.rentalDue | formatDate}}</td>
              <td >R$ {{ item.value }}</td>
              <td class="text-xs-right">
                <v-btn
                    class="mx-0 font-weight-light"
                    color="success"
                    @click="devolutionRent(item)"
                  >
                    Devolução
                  </v-btn>
              </td>
            </template>
          </v-data-table>
        </material-card>
      </v-flex>
      <v-flex
        md12
      >
        <material-card
          color="green"
          flat
          full-width
          title="Reservas"
        >
          <v-data-table
            :headers="headers"
            :items="reserves"
            hide-actions
          >
            <template
              slot="headerCell"
              slot-scope="{ header }"
            >
              <span
                class="subheading font-weight-light text--darken-3"
                v-text="header.text"
              />
            </template>
            <template
              slot="items"
              slot-scope="{ item }"
            >
              <td>{{ item.client.name }}</td>
              <td>{{ item.rentalDate | formatDate}}</td>
              <td>{{ item.rentalDue | formatDate}}</td>
              <td >R$ {{ item.value }}</td>
              <td class="text-xs-right">
                <v-btn
                    class="mx-0 font-weight-light"
                    color="success"
                    @click="cancelReserve(item)"
                  >
                    Cancelar
                  </v-btn>
              </td>
            </template>
          </v-data-table>
        </material-card>
      </v-flex>
    </v-layout>
    <v-snackbar
              :color="color"
              :top="true"
              :right="true"
              v-model="snackbar"
              dark
            >
              <v-icon
                color="white"
                class="mr-3"
              >
                mdi-bell-plus
              </v-icon>
              <div>{{msg}}</div>
              <v-icon
                size="16"
                @click="snackbar = false"
              >
                mdi-close-circle
              </v-icon>
   </v-snackbar>
  </v-container>
  
</template>

<script>
import send from "../utils/request.js";
import moment from "moment";
export default {
  data: () => ({
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
      },
      {
        sortable: false,
        text: 'Ações',
        align: 'right'
      }
    ],
    msg: '',
    snackbar: false,
    rents: [],
    reserves:[]
  }),
  created() {
    this.getItens(0)
    this.getReserves(0)
  },
  filters: {
    formatDate: function(value) {
      if (!value) return ""
      return moment(String(value)).format("DD/MM/YYYY HH:ss")
    }
  },
  methods: {
    snack (...args) {

      for (const loc of args) {
        this[loc] = true
      }

      this.color = this.colors[Math.floor(Math.random() * this.colors.length)]

      this.snackbar = true
    },
    getItens(page) {
      send
        .request("get", "rents?"+"page="+ page)
        .then(response => {
          
          this.rents = response.data.content;
          console.log(this.rents)
        })
        .catch(error => {
          console.log(error)
        });
    },
    getReserves(page) {
      send
        .request("get", "rents/reserves?"+"page="+ page)
        .then(response => {
          
          this.reserves = response.data.content;
          console.log(this.reserves)
        })
        .catch(error => {
          console.log(error)
        });
    },
    cancelReserve(row) {
      send
        .request("put", "rents/cancelled/"+row.id)
        .then(response => {
          this.$router.push({
              path: "/alugueis"
            });
            this.getReserves(0)
          console.log(response.data)
        })
        .catch(error => {
          console.log(error)
        });
    },
    devolutionRent(row) {
      send
        .request("put", "rents/devolution/"+row.id)
        .then(response => {
          this.$router.push({
              path: "/alugueis"
            });
            this.getItens(0)
          console.log(response.data)
        })
        .catch(error => {
          console.log(error)
        });
    }
  }
}
</script>
