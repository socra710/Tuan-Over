export const UserInfo = {
    namespaced: true,
    state: { // [변수들의 집합]
        userId: '',
        userNm: '',
        userImg: ''
    },
    getters: { // [state의 변수들을 get 호출]
        getUserInfo(state: any){
            return state;
        }
    },
    mutations: { // [변수들을 조작하는 함수들]
        setUserInfo(state: any, objUser: any){
            state.userId = objUser.userId;
            state.userNm = objUser.userNm;
            state.userImg = objUser.userImg;
        }
    },
    actions: { // [비동기 처리를 하는 함수들]
    },
};