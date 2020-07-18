## 递归写法结构总结

```
function fn(n) {

    //第一步：判断输入或者状态是否合法
    if (input/state is invalid) {
        return;
    }

    //第二步：判断递归是否应当结束
    if (match condition) {
        return some value;
    }

    //第三步: 缩小问题规模
    result1 = fn(n1)
    result2 = fn(n2)
    ...condition

    //第四步：整合结果
    return combine(result1, result2)


}
```