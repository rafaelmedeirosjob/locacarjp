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
          title="Alugueis em andamento"
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
              <td>{{ item.rentalDate }}</td>
              <td>{{ item.rentalDue }}</td>
              <td class="text-xs-right">{{ item.value }}</td>
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
            :items="rents"
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
              <td>{{ item.rentalDate }}</td>
              <td>{{ item.rentalDue }}</td>
              <td class="text-xs-right">{{ item.value }}</td>
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
        value: 'value',
        align: 'right'
      }
    ],
    rents: [],
    reserves:[]
  }),
  created() {
    this.getItens(1)
  },
  methods: {
    getItens(page) {
      send
        .request("get", "rents")
        .then(response => {
          
          this.rents = response.data.content;
          console.log(this.rents)
        })
        .catch(error => {
          console.log(error)
        });
    }
  }
}
</script>
