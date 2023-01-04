<template>
  <div>
    <div class="flex flex-col">
      <div class="flex flex-row">
        <div class="flex-1 text-center"><h3 class="text-3xl font-medium text-gray-700">My Links</h3></div>
        <div class="flex-1 text-center">
          <button class="bg-purple-500 hover:bg-purple-700 text-white font-bold py-2 px-4 rounded inline-flex items-center">
            <svg class="w-8 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13.828 10.172a4 4 0 00-5.656 0l-4 4a4 4 0 105.656 5.656l1.102-1.101m-.758-4.899a4 4 0 005.656 0l4-4a4 4 0 00-5.656-5.656l-1.1 1.1"></path></svg>
            <span>Add Link</span>
          </button>
        </div>
      </div>
      <div class="flex justify-center mt-5" v-for="(item, index) in links.items" :key="index">
        <div class="flex-1 flex-col bg-white p-5">
          <div class="flex justify-end">
            <button>
              <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z"></path></svg>
            </button>
          </div>
          <dt class="mb-5 text-gray-500 md:text-lg dark:text-gray-400"><a href="https://naver.com" target="_blank">{{ item['title'] }}</a></dt>
          <dd class="text-lg font-semibold">
            <span class="inline-flex px-3 text-xs leading-5 text-purple-500 bg-purple-200 rounded-full mx-1" v-for="tag in splitedList(item['tagNames'])">{{ tag }}</span>
          </dd>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import {computed, defineComponent, reactive, ref} from "vue";
import axios from "axios";
import {userInfo} from "@/stores/UserInfo";

export default defineComponent({
  name: "Linkfor",
  setup() {
    let links = reactive({
        items: []
    })

    axios.get('/api/links').then(({data}) => {
      if (data) {
        links.items = data;
      }
    });

    function splitedList(row: string | null) {
      return (row != null) ? row.split(',') : '';
    }

    return {
      links,
      splitedList
    }
  },
});
</script>
