<template>
    <div>
    <el-table
            :data="tableData"
            border
            style="width: 100%">
        <el-table-column
                fixed
                prop="id"
                label="编号"
                width="150">
        </el-table-column>
        <el-table-column
                prop="name"
                label="姓名"
                width="120">
        </el-table-column>
        <el-table-column
                prop="number"
                label="工号"
                width="120">
        </el-table-column>
        <el-table-column
                prop="time"
                label="签到时间"
                width="120">
        </el-table-column>
        <el-table-column
                prop="address"
                label="地址"
                width="300">
        </el-table-column>
        <el-table-column
                fixed="right"
                label="操作"
                width="100">
            <template slot-scope="scope">
                <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                <el-button type="text" size="small">编辑</el-button>
            </template>
        </el-table-column>
    </el-table>
    <el-pagination
            background
            layout="prev, pager, next"
            page-size="5"
            :total="30"
             @current-change="page">
    </el-pagination>
    </div>
</template>

<script>
    export default {
        methods: {
            handleClick(row) {
                console.log(row);
            },
            page(currentPage){
                const _this=this
                axios.get('http://localhost:8000/signin/findAll/'+currentPage+'/5').then(function (resp) {
                    _this.tableData=resp.data.content
                    _this.total=resp.data.totalElements
                })
            }
        },
        created(){
            const _this=this
            axios.get('http://localhost:8000/signin/findAll/1/5').then(function (resp) {
                _this.tableData=resp.data.content
                _this.total=resp.data.totalElements
            })
        },
        data() {
            return {
                total:null,
                tableData:null
            }
        }
    }
</script>