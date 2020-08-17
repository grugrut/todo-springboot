import Vuex from 'vuex';
import axios from 'axios';

const createStore = () => {
  return new Vuex.Store({
    state: () => ({
      items: []
    }),
    mutations: {
      getItems: (state, items) => {
        state.items = items;
      },
    },
    actions: {
      async getItems ({commit}) {
        let {data} = await this.$axios.get('/api/v1/items');
        console.log(data);
        commit('getItems', data);
      },
      async remove({commit}, {item}) {
        let {result} = await this.$axios.delete('/api/v1/items/' + item.id);
        let {data} = await this.$axios.get('/api/v1/items');
        commit('getItems', data);
      },
      async changeState({commit}, {item}) {
        item.status = (item.status == 0) ? 1 : 0;
        let result = await this.$axios.put('/api/v1/items', item);
        let {data} = await this.$axios.get('/api/v1/items');
        commit('getItems', data);
      },
      async add({commit}, {name, status}) {
        let result = await this.$axios.post('/api/v1/items', {name: name, status: status});
        let {data} = await this.$axios.get('/api/v1/items');
        commit('getItems', data);
      }
    }
  })
}

export default createStore;
