<template>
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="姓名" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="学号" prop="number">
            <el-input v-model="ruleForm.number"></el-input>
        </el-form-item>
        <el-form-item label="签到时间" prop="time">
            <el-input v-model="ruleForm.time"></el-input>
        </el-form-item>
        <el-form-item label="签到地址" prop="address">
            <el-input v-model="ruleForm.address"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    name: '',
                    number: '',
                    time:'',
                    address:'',
                },
                rules: {
                    name: [
                        { required: true, message: '请输入学生姓名', trigger: 'blur' },
                        { min: 1, max: 8, message: '长度在 1 到 8 个字符', trigger: 'blur' }
                    ],
                    number: [
                        { required: true, message: '请输入学生学号', trigger: 'blur' },
                        { min: 1, max: 8, message: '长度在 1 到 8 个字符', trigger: 'blur' }
                    ],
                    time: [
                        {  required: true, message: '请输入签到时间', trigger: 'blur' }
                    ],
                    address: [
                        { required: true, message: '请输入签到地址', trigger: 'blur' }
                    ],
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this=this
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.post('http://localhost:8000/signin/save',this.ruleForm).then(function (resp) {
                            if (resp.data==='success'){
                                _this.$router.push('/one')
                            }
                        })
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>