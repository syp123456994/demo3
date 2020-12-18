import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import One from '../views/One'
import Two from '../views/Two'
import Three from '../views/Three'
import Four from '../views/Four'
import App from '../App'
import Five from '../views/Five'
import Six from '../views/Six'
import index from '../views/index'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: '管理员',
    component: index,
    redirect:'/one',
    children:[
      {
        path: '/one',
        name: "查询学生信息",
        component: One
      },
      {
        path: '/two',
        name: "添加学生信息",
        component: Two
      }
    ]
  },
  {
    path:'/Teacher',
    name:"导航2",
    component:index,
    children:[
      {
        path: '/three',
        name: "页面3",
        component: Three
      },
      {
        path: '/four',
        name: "页面4",
        component: Four
      },
    ]
  },
  {
    path:'/admin',
    name:"导航3",
    component:index,
    children:[
      {
        path: '/five',
        name: "页面5",
        component: Five,
      },
      {
        path: '/six',
        name: "页面6",
        component: Six
      },
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
