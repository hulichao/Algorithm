# 解决回溯问题的套路模板
```$xslt
function fn(n) {
    //第一步：判断输入状态是否合法
    if (input/state is invalid) {
        return;
    }
    //第二步：判断递归是否应当结束
    if (match condition) {
        return some value;
    }
    //遍历有可能出现的情况
    for(all possible cases) {
        //第三步：尝试下一步的可能性
        solution.push(case)
        //递归
        result = fn(m)
        //第四步：回溯到上一步
        solution.pop(case)
    }

}
```