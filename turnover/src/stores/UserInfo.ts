import { defineStore } from "pinia";

export const userInfo = defineStore("list",{
    state : () => ({
        userId: '',
        userNm: '',
        userImg: ''
    }),
    persist: {
        key: 'userInfo',
        storage: sessionStorage
    },
    actions: {
        setUserInfo(objUser: any){
            this.$state.userId = objUser.userId;
            this.$state.userNm = objUser.userNm;
            this.$state.userImg = objUser.userImg;
        }
    },
    getters: {
        getUserInfo(state: any){
            return state;
        }
    }
});