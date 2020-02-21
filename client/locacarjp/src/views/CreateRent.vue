<template>
  <v-container
    fill-height
    fluid
    grid-list-xl>
    <v-layout
      justify-center
      wrap
    >
      <v-flex
        xs12
        md8
      >
        <material-card
          color="green"
          title="Aluguel"
          text="Preencha todas as informações"
        >
        <badger-accordion >
              <badger-accordion-item>
                  <template slot="header">
                    <button class="badger-accordion__trigger js-badger-accordion-header">
                          <div class="badger-accordion__trigger-title">
                              Cliente
                          </div>
                          <div class="badger-accordion__trigger-icon">
                          </div>
                      </button>
                      </template>    
                  <template slot="content">
                    <v-form ref="form" v-model="valid">
                  <v-container py-0>
                    <v-layout wrap>
                      <v-flex
                        xs12
                        md4
                      > 
                        <v-text-field
                          :rules="rules.required"
                          v-model="model.nameClient"
                          label="NOME COMPLETO"/>
                      </v-flex>
                      <v-flex
                        xs12
                        md4
                      >
                        <v-text-field :rules="rules.required"
                          v-model="model.cpf"
                          class="purple-input"
                          label="CPF"
                        />
                      </v-flex>
                      <v-flex
                        xs12
                        md4
                      >
                        <v-text-field :rules="rules.required"
                        v-model="model.number"
                          label="NÚMERO"
                          class="purple-input"/>
                      </v-flex>
                      <v-flex
                        xs12
                        md6
                      >
                        <v-text-field :rules="rules.required"
                        v-model="model.street"
                          label="RUA"
                          class="purple-input"/>
                      </v-flex>
                      <v-flex
                        xs12
                        md6
                      >
                        <v-text-field :rules="rules.required"
                        v-model="model.city"
                          label="CIDADE"
                          class="purple-input"/>
                      </v-flex>
                      <v-flex
                        xs12
                        text-xs-right
                      >
                      </v-flex>
                      
                    </v-layout>
            </v-container>  
                  </v-form>
                  </template>  
              </badger-accordion-item>

              <badger-accordion-item>
                  <template slot="header">
                    <button class="badger-accordion__trigger js-badger-accordion-header">
                          <div class="badger-accordion__trigger-title">
                              Veículo
                          </div>
                          <div class="badger-accordion__trigger-icon">
                          </div>
                      </button>
                      </template>    
                  <template slot="content"> <v-form ref="form" v-model="valid">
                    <v-container py-0>
              <v-layout wrap>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                    v-model="model.vehiclePlate"
                    label="PLACA"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.model"
                    class="purple-input"
                    label="MODELO"
                  />
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.km"
                    label="KM"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.fuel"
                    label="Combustível"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.motorPower"
                    label="Potência do motor"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.type"
                    label="Tipo"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.exchange"
                    label="Câmbio"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.door"
                    label="Portas"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.color"
                    label="Cor"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  text-xs-right
                >
                </v-flex>
              </v-layout>
            </v-container>  </v-form> </template>  
              </badger-accordion-item>
              <badger-accordion-item>
                  <template slot="header">
                    <button class="badger-accordion__trigger js-badger-accordion-header">
                          <div class="badger-accordion__trigger-title">
                              Aluguel
                          </div>
                          <div class="badger-accordion__trigger-icon">
                          </div>
                      </button>
                      </template>    
                  <template slot="content"> <v-form ref="form" v-model="valid">
                  <v-container py-0>
              <v-layout wrap>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.rentalDate"
                    label="Data de aluguel"/>
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.rentalDue"
                    class="purple-input"
                    label="Data de entrega"
                  />
                </v-flex>
                <v-flex
                  xs12
                  md4
                >
                  <v-text-field :rules="rules.required"
                  v-model="model.value"
                    label="Valor"
                    class="purple-input"/>
                </v-flex>
                <v-flex
                  xs12
                  text-xs-right
                >
                </v-flex>
              </v-layout>
            </v-container> </v-form>
                  </template>  
                                </badger-accordion-item>
                            </badger-accordion>
                            <div align="right"><v-btn    :disabled="!valid" 
                                      class="mx-0 font-weight-light"
                                      color="success"
                                      @click="checkForm"
                                    >
                                      Alugar
                                    </v-btn></div>
                          </material-card>
                        </v-flex>
                        <v-flex
                          xs12
                          md4
                        >
                        </v-flex>
                      </v-layout>
                    </v-container>
                  </template>

<script>
import Vue from 'vue'
import send from "../utils/request.js";
import {BadgerAccordion, BadgerAccordionItem} from 'vue-badger-accordion'
Vue.component('BadgerAccordion', BadgerAccordion)
Vue.component('BadgerAccordionItem', BadgerAccordionItem)
export default {
  components: {
        BadgerAccordion,
        BadgerAccordionItem
    },
    data: () => ({
      valid: true,
      rules: {
       required: [value => !!value || " Campo obrigatório."]
      },
    model:
    {
      rentalDate: '',
      rentalDue: '',
      value: '',
      nameClient: '',
      cpf: '',
      street: '',
      number: '',
      city: '',
      model: '',
      vehiclePlate: '',
      km: '',
      fuel: '',
      type: '',
      motorPower: '',
      exchange: '',
      door: '',
      color: ''
    }}),
    methods: {
      checkForm()
      {
        if (this.$refs.form.validate()) {
        send
        .request("post", "rents",{
          rentalDate: this.model.rentalDate,
          rentalDue: this.model.rentalDue,
          value: this.model.value,
          nameClient: this.model.nameClient,
          cpf: this.model.cpf,
          street: this.model.street,
          number: this.model.number,
          city: this.model.city,
          model: this.model.model,
          vehiclePlate: this.model.vehiclePlate,
          km: this.model.km,
          fuel: this.model.fuel,
          type: this.model.type,
          motorPower: this.model.motorPower,
          exchange: this.model.exchange,
          door: this.model.door,
          color: this.model.color
        })
        .then(response => {
          this.$router.push({
              path: "/alugueis"
            })
        })
        .catch(error => {
          console.log(error)
        });
        }
      }
    }
  //
}
</script>
<style scoped>
.badger-accordion__panel {
  max-height: 75vh;
  overflow: hidden;
}
.badger-accordion__panel.-ba-is-hidden {
  max-height: 0 !important;
}
.badger-accordion--initialized .badger-accordion__panel {
  -webkit-transition: max-height ease-in-out 0.2s;
  transition: max-height ease-in-out 0.2s;
}

.badger-accordion {
  box-shadow: 0 1px 10px rgba(0, 0, 0, 0.1), 0 1px 4px rgba(0, 0, 0, 0.1);
  border-radius: 4px;
  overflow: hidden;
}

.badger-accordion__header:not(:last-of-type) {
  border-bottom: 1px solid #eff1f0;
}

.badger-accordion__trigger {
  align-content: space-between;
  -webkit-box-align: center;
          align-items: center;
  background-color: #fff;
  border: 0;
  border-radius: 0px;
  color: #34495e;
  display: -webkit-box;
  display: flex;
  font-family: "Josefin Sans", Arial;
  font-size: 1.25rem;
  line-height: 1;
  padding: 20px;
  text-align: left;
  -webkit-transition: all ease-in-out 0.2s;
  transition: all ease-in-out 0.2s;
  width: 100%;
}
.badger-accordion__trigger[aria-expanded="true"] .badger-accordion__trigger-icon:before {
  -webkit-transform: rotate(45deg) translate3d(13px, 14px, 0);
          transform: rotate(45deg) translate3d(13px, 14px, 0);
}
.badger-accordion__trigger[aria-expanded="true"] .badger-accordion__trigger-icon:after {
  -webkit-transform: rotate(-45deg) translate3d(-13px, 14px, 0);
          transform: rotate(-45deg) translate3d(-13px, 14px, 0);
}
.badger-accordion__trigger:focus, .badger-accordion__trigger:hover {
  background-color: #16a085;
  cursor: pointer;
  outline: none;
}
.badger-accordion__trigger:focus .badger-accordion__trigger-title, .badger-accordion__trigger:hover .badger-accordion__trigger-title {
  color: #fff;
}
.badger-accordion__trigger:focus .badger-accordion__trigger-icon:after, .badger-accordion__trigger:focus .badger-accordion__trigger-icon:before, .badger-accordion__trigger:hover .badger-accordion__trigger-icon:after, .badger-accordion__trigger:hover .badger-accordion__trigger-icon:before {
  background-color: #fff;
}
.badger-accordion__trigger::-moz-focus-inner {
  border: none;
}

.badger-accordion__trigger-title {
  font-size: 1.2rem;
  -webkit-transition: ease-in-out 0.3s;
  transition: ease-in-out 0.3s;
}

.badger-accordion__trigger-icon {
  display: block;
  height: 40px;
  margin-left: auto;
  position: relative;
  -webkit-transition: all ease-in-out 0.2s;
  transition: all ease-in-out 0.2s;
  width: 40px;
}
.badger-accordion__trigger-icon:after, .badger-accordion__trigger-icon:before {
  background-color: #333;
  content: "";
  height: 3px;
  position: absolute;
  top: 10px;
  -webkit-transition: all ease-in-out 0.1333333333s;
  transition: all ease-in-out 0.1333333333s;
  width: 30px;
}
.badger-accordion__trigger-icon:before {
  left: 1px;
  -webkit-transform: rotate(45deg) translate3d(8px, 22px, 0);
          transform: rotate(45deg) translate3d(8px, 22px, 0);
  -webkit-transform-origin: 100%;
          transform-origin: 100%;
}
.badger-accordion__trigger-icon:after {
  -webkit-transform: rotate(-45deg) translate3d(-8px, 22px, 0);
          transform: rotate(-45deg) translate3d(-8px, 22px, 0);
  right: 1px;
  -webkit-transform-origin: 0;
          transform-origin: 0;
}

.badger-accordion__panel {
  background-color: #fafafa;
  position: relative;
}
.badger-accordion__panel:after {
  background-color: #eff1f0;
  bottom: 0;
  content: "";
  height: 2px;
  left: 0;
  position: absolute;
  width: 100%;
}

.badger-accordion__panel-inner {
  padding: 20px 20px 40px;
}

@media screen and (max-width: 767px) {
  .badger-accordion__trigger-icon {
    display: none;
    padding: 20px;
  }
}
</style>
