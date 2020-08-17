<template>
  <div class="container">
    <h1 class="title">Todo</h1>
    <div class="row my-4 justify-content-md-center">
      <div class="col-md-6 ">
        <input type="text" class="form-control" name="taskName" id="taskName" v-model="taskName">
      </div>
      <div class="col-md-1">
        <button id="addButton" class="btn btn-primary" @click="add">追加</button>
      </div>
    </div>
    <div>
      <table class="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>STATUS</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in items" :key="item.id">
            <td>#{{item.id}}</td>
            <td>{{item.name}}</td>
            <td><button class="btn btn-primary" @click="$store.dispatch('changeState', {item: item})">
              <span v-if="item.status == 0">TODO</span>
              <span v-else>Done</span>
            </button></td>
            <td><button class="btn btn-danger" @click="$store.dispatch('remove', {item: item})">削除</button></td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  </div>
</template>

<script>
 import {mapState} from 'vuex'
 
 export default {
   data() {
     return {
       taskName: '',
     }
   },
   computed: {
     ...mapState([
       "items"
     ]),
   },
   created () {
     this.$store.dispatch('getItems');
   },
   methods: {
     add: function() {
       if (this.taskName != '') {
         this.$store.dispatch('add', {name: this.taskName, status: 0});
         this.taskName = '';
       }
     }
   }
 }
</script>

<style>
 .container {
   margin: 0 auto;
   min-height: 100vh;
   justify-content: center;
   align-items: center;
   text-align: center;
 }

 .title {
   font-family:
     'Quicksand',
     'Source Sans Pro',
     -apple-system,
     BlinkMacSystemFont,
     'Segoe UI',
     Roboto,
     'Helvetica Neue',
     Arial,
     sans-serif;
   display: block;
   font-weight: 300;
   font-size: 100px;
   color: #35495e;
   letter-spacing: 1px;
 }

 .subtitle {
   font-weight: 300;
   font-size: 42px;
   color: #526488;
   word-spacing: 5px;
   padding-bottom: 15px;
 }

 .links {
   padding-top: 15px;
 }
</style>
