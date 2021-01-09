# 博客接口文档

## 博客信息列表

### 接口说明

获取博客信息

| 请求方式 | HTTP GET                                                     |
| -------- | ------------------------------------------------------------ |
| 接口地址 | /api/blog/list                                               |
| Demo     | http://47.107.64.157:8080/api/blog/list?pageNum=1&pageSize=10 |
| 调用方向 | 博客前端-->博客服务                                          |

### 请求参数说明

| 变量名   | 类型    | 是否必须 | 说明     |
| -------- | ------- | -------- | -------- |
| pageNum  | Integer | 是       | 页号     |
| pageSize | Integer | 是       | 每页大小 |

### 响应参数说明

| 变量名            | 类型    | 是否必须 | 说明                 |
| ----------------- | ------- | -------- | -------------------- |
| status            | Integer | 是       | 响应码               |
| msg               | Integer | 是       | 响应码说明           |
| result            | Object  | 是       | 对象                 |
| data              | List    | 是       | 每个对象包含以下字段 |
| total             | Integer | 是       | 总数量               |
| list              | List    | 是       | 每个对象包含以下字段 |
|                   |         |          |                      |
| blog对象          |         |          |                      |
| blogNo            | String  | 是       | 博客编号             |
| blogCoverUrl      | String  | 是       | 封面路径             |
| blogType          | String  | 是       | 博客类型             |
| blogTagList       | String  | 是       | 博客标签             |
| blogTitle         | String  | 是       | 标题                 |
| blogOverview      | String  | 是       | 概览                 |
| createTime        | Date    | 是       | 创建时间             |
|                   |         |          |                      |
| pageNum           | Integer | 是       | 当前页号             |
| pageSize          | Integer | 是       | 每页大小             |
| size              | Integer | 是       | 当前页个数           |
| startRow          | Integer | 是       | 由第几条开始         |
| endRow            | Integer | 是       | 到第几条结束         |
| pages             | Integer | 是       | 总页数               |
| prePage           | Integer | 是       | 上一页号             |
| nextPage          | Integer | 是       | 下一页号             |
| isFirstPage       | blooean | 是       | 首页标识             |
| isLastPage        | blooean | 是       | 尾页标识             |
| hasPreviousPage   | blooean | 是       | 上一页标识           |
| hasNextPage       | blooean | 是       | 下一页标识           |
| navigatePages     | Integer | 是       | 每页显示的页码个数   |
| navigatepageNums  | List    | 是       | 页码数               |
| navigateFirstPage | Integer | 是       | 首页                 |
| navigateLastPage  | Integer | 是       | 尾页                 |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": {
      "total": 7,
      "list": [
        {
          "blogNo": "B65f81604318223526",
          "blogCoverUrl": "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
          "blogType": "test",
          "blogTagList": "[]",
          "blogTitle": "test",
          "blogOverview": "",
          "createTime": "2021-01-08T04:05:33.000+0000"
        },
        {
          "blogNo": "Bc7331604318223526",
          "blogCoverUrl": "http://47.107.64.157/blog/20210107/08f91604318223526.jpg",
          "blogType": "机器学习",
          "blogTagList": "[{\"name\":\"机器学习\"},{\"name\":\"深度学习\"}]",
          "blogTitle": "2_回归_案例学习",
          "blogOverview": "回归",
          "createTime": "2021-01-07T08:47:35.000+0000"
        }
      ],
      "pageNum": 1,
      "pageSize": 2,
      "size": 2,
      "startRow": 1,
      "endRow": 2,
      "pages": 4,
      "prePage": 0,
      "nextPage": 2,
      "isFirstPage": true,
      "isLastPage": false,
      "hasPreviousPage": false,
      "hasNextPage": true,
      "navigatePages": 8,
      "navigatepageNums": [
        1,
        2,
        3,
        4
      ],
      "navigateFirstPage": 1,
      "navigateLastPage": 4,
      "lastPage": 4,
      "firstPage": 1
    }
  }
}
```



## 一篇博客信息

### 接口说明

返回一篇博客信息

| 请求方式 | HTTP GET                                                |
| -------- | ------------------------------------------------------- |
| 接口地址 | /api/blog/query/one                                     |
| Demo     | http://47.107.64.157:8080/api/blog/query/one?blogNo=001 |
| 调用方向 | 博客前端-->博客服务                                     |

### 请求参数说明

| 变量名 | 类型   | 是否必须 | 说明     |
| ------ | ------ | -------- | -------- |
| blogNo | String | 是       | 博客编号 |

### 响应参数

| 变量名         | 类型    | 是否必须 | 说明             |
| -------------- | ------- | -------- | ---------------- |
| status         | Integer | 是       | 响应码           |
| msg            | Integer | 是       | 响应码说明       |
| result         | Object  | 是       | 对象             |
| data           | List    | 是       | 对象包含以下字段 |
| blogNo         | String  | 是       | 博客编号         |
| blogCoverUrl   | String  | 是       | 封面URL          |
| blogType       | String  | 是       | 博客类型         |
| blogTagList    | String  | 是       | 博客标签         |
| blogTitle      | String  | 是       | 标题             |
| blogOverview   | String  | 是       | 概览             |
| blogRawContent | String  | 是       | markdown源代码   |
| createTime     | Date    | 是       | 创建时间         |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": {
      "blogNo": "001",
      "blogCoverUrl": "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
      "blogType": "技术",
      "blogTagList": "[{\"name\":\"java\"},{\"name\":\"hashMap\"},{\"name\":\"源码\"}]",
      "blogTitle": "几个Hash容器的区别",
      "blogOverview": "有关于java源码以及常用集合",
      "blogRawContent": "xxx",
      "createTime": "2020-09-29T10:24:34.000+0000"
    }
  }
}
```



## 个人简历和在校经历

### 接口说明

返回个人简历个在校经历

| 请求方式 | HTTP GET                                     |
| -------- | -------------------------------------------- |
| 接口地址 | /api/blog/query/special                      |
| Demo     | http://localhost:9192/api/blog/query/special |
| 调用方向 | 博客前端-->博客服务                          |

### 响应参数说明

| 变量名       | 类型    | 是否必须 | 说明                 |
| ------------ | ------- | -------- | -------------------- |
| status       | Integer | 是       | 响应码               |
| msg          | String  | 是       | 响应码说明           |
| result       | Object  | 是       | 对象                 |
| data         | List    | 是       | 每个对象包含以下字段 |
| blogNo       | String  | 是       | 博客编号             |
| blogCoverUrl | String  | 是       | 封面URL              |
| blogType     | String  | 是       | 博客类型             |
| blogTagList  | String  | 是       | 标签列表             |
| blogTitle    | String  | 是       | 标题                 |
| blogOverview | String  | 是       | 概览                 |
| createTime   | Date    | 是       | 创建时间             |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": [
      {
        "blogNo": "002",
        "blogCoverUrl": "https://cube.elemecdn.com/6/94/4d3ea53c084bad6931a56d5158a48jpeg.jpeg",
        "blogType": "工作经历",
        "blogTagList": "[]",
        "blogTitle": "自我介绍-工作",
        "blogOverview": "暂无概要",
        "createTime": "2020-06-17T16:00:00.000+0000"
      }
    ]
  }
}

```



## 新增博客

### 接口说明

增加一篇博客

| 请求方式 | HTTP POST                               |
| -------- | --------------------------------------- |
| 接口地址 | /api/blog/add/blog                      |
| Demo     | http://localhost:9192/api/blog/add/blog |
| 调用方向 | 博客前端-->博客服务                     |

### 请求参数说明

| 变量名         | 类型   | 是否必须 | 说明     |
| -------------- | ------ | -------- | -------- |
| blogCoverUrl   | String | 是       | 封面内容 |
| blogRawContent | String | 是       | 内容     |
| blogOverview   | String | 是       | 概览     |
| blogTagList    | String | 是       | 标签列表 |
| blogTitle      | String | 是       | 标题     |
| blogType       | String | 是       | 类型     |

示例

```json
{
  "blogCoverUrl": "string",
  "blogOverview": "string",
  "blogRawContent": "string",
  "blogTagList": "string",
  "blogTitle": "string",
  "blogType": "string"
}
```



### 响应参数说明

| 变量名 | 类型    | 是否必须 | 说明         |
| ------ | ------- | -------- | ------------ |
| status | Integer | 是       | 响应码       |
| msg    | String  | 是       | 响应码说明   |
| result | Object  | 是       | 包含以下字段 |
| data   | String  | 是       | 无特殊含义   |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": null
  }
}
```



## 更新博客状态

### 接口说明

更新博客状态

| 请求方式 | HTTP GET                                                     |
| -------- | ------------------------------------------------------------ |
| 接口地址 | /api/blog/update/status                                      |
| Demo     | http://localhost:9192/api/blog/update/status?blogNo=Bdff01601364803522&status=-1 |
| 调用方向 | 博客前端-->博客服务                                          |

### 请求参数说明

| 变量名    | 类型   | 是否必须 | 说明     |
| --------- | ------ | -------- | -------- |
| blogNo | String | 是      | 博客Id |
| status | Integer | 是      | 状态<br />-1为已删除，1为正常使用,2为特殊文章            |

### 响应参数说明

| 变量名 | 类型    | 是否必须 | 说明         |
| ------ | ------- | -------- | ------------ |
| status | Integer | 是       | 响应码       |
| msg    | String  | 是       | 响应码说明   |
| result | Object  | 是       | 包含以下字段 |
| data   | String  | 是       | 无特殊含义   |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": null
  }
}
```



## 更新博客内容

### 接口说明

更新博客内容

| 请求方式 | HTTP POST                                     |
| -------- | --------------------------------------------- |
| 接口地址 | /api/blog/update/content                      |
| Demo     | http://localhost:9192/api/blog/update/content |
| 调用方向 | 博客前端-->博客服务                           |

### 请求参数说明

| 变量名         | 类型   | 是否必须 | 说明     |
| -------------- | ------ | -------- | -------- |
| blogNo         | String | 是       | 博客编号 |
| blogCoverUrl   | String | 是       | 封面URL  |
| blogRawContent | String | 是       | 内容     |
| blogOverview   | String | 是       | 概览     |
| blogTagList    | String | 是       | 标签列表 |
| blogTitle      | String | 是       | 标题     |
| blogType       | String | 是       | 分类     |

示例

```json
{
  "blogCoverUrl": "string",
  "blogNo": "string",
  "blogOverview": "string",
  "blogRawContent": "string",
  "blogTagList": "string",
  "blogTitle": "string",
  "blogType": "string"
}
```



### 响应参数说明

| 变量名 | 类型    | 是否必须 | 说明         |
| ------ | ------- | -------- | ------------ |
| status | Integer | 是       | 响应码       |
| msg    | String  | 是       | 响应码说明   |
| result | Object  | 是       | 包含以下字段 |
| data   | String  | 是       | 包含以下字段 |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": null
  }
}
```



## markdown文件导出

### 接口说明

导出为md文件

| 请求方式 | HTTP GET                                              |
| -------- | ----------------------------------------------------- |
| 接口地址 | /api/blog/download/md                                 |
| Demo     | http://localhost:9192/api/blog/download/md?blogNo=001 |
| 调用方向 | 博客前端-->博客服务                                   |

### 请求参数说明

| 变量名 | 类型   | 是否必须 | 说明     |
| ------ | ------ | -------- | -------- |
| blogNo | String | 是       | 博客编号 |



## markdown上传图片

### 接口说明

上传博客中的图片

| 请求方式 | HTTP GET                                  |
| -------- | ----------------------------------------- |
| 接口地址 | /api/blog/upload/img                      |
| Demo     | http://localhost:9192/api/blog/upload/img |
| 调用方向 | 博客前端-->博客服务                       |

### 请求参数说明

| 变量名 | 类型 | 是否必须 | 说明       |
| ------ | ---- | -------- | ---------- |
| file   | File | 是       | 上传的图片 |

### 响应参数说明

| 变量名 | 类型    | 是否必须 | 说明         |
| ------ | ------- | -------- | ------------ |
| status | Integer | 是       | 响应码       |
| msg    | String  | 是       | 响应码说明   |
| result | Object  | 是       | 包含以下字段 |
| data   | String  | 是       | 包含以下字段 |
| imgUrl | String  | 是       | 图片路径     |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": {
      "imgUrl": "http://47.107.64.157/blog/20201002/d8a21601653305763.jpg"
    }
  }
}
```





## 局部文章搜索

### 接口说明

根据文章标题搜索文章内容

| 请求方式 | HTTP GET                                                     |
| -------- | ------------------------------------------------------------ |
| 接口地址 | http://localhost:9192/api/blog/queryByKey                    |
| Demo     | http://localhost:9192/api/blog/queryByKey?pageNum=1&pageSize=6&queryKey=%E6%9C%BA%E5%99%A8%E5%AD%A6%E4%B9%A0 |
| 调用方向 | 博客前端-->博客服务                                          |

### 请求参数说明

| 变量名   | 类型    | 是否必须 | 说明           |
| -------- | ------- | -------- | -------------- |
| queryKey | String  | 是       | 文章标题关键字 |
| pageNum  | Integer | 是       | 页号           |
| pageSize | Integer | 是       | 每页大小       |

### 响应参数说明

| 变量名            | 类型    | 是否必须 | 说明                 |
| ----------------- | ------- | -------- | -------------------- |
| status            | Integer | 是       | 响应码               |
| msg               | Integer | 是       | 响应码说明           |
| result            | Object  | 是       | 对象                 |
| data              | List    | 是       | 每个对象包含以下字段 |
| total             | Integer | 是       | 总数量               |
| list              | List    | 是       | 每个对象包含以下字段 |
|                   |         |          |                      |
| blog对象          |         |          |                      |
| blogNo            | String  | 是       | 博客编号             |
| blogCoverUrl      | String  | 是       | 封面路径             |
| blogType          | String  | 是       | 博客类型             |
| blogTagList       | String  | 是       | 博客标签             |
| blogTitle         | String  | 是       | 标题                 |
| blogOverview      | String  | 是       | 概览                 |
| createTime        | Date    | 是       | 创建时间             |
|                   |         |          |                      |
| pageNum           | Integer | 是       | 当前页号             |
| pageSize          | Integer | 是       | 每页大小             |
| size              | Integer | 是       | 当前页个数           |
| startRow          | Integer | 是       | 由第几条开始         |
| endRow            | Integer | 是       | 到第几条结束         |
| pages             | Integer | 是       | 总页数               |
| prePage           | Integer | 是       | 上一页号             |
| nextPage          | Integer | 是       | 下一页号             |
| isFirstPage       | blooean | 是       | 首页标识             |
| isLastPage        | blooean | 是       | 尾页标识             |
| hasPreviousPage   | blooean | 是       | 上一页标识           |
| hasNextPage       | blooean | 是       | 下一页标识           |
| navigatePages     | Integer | 是       | 每页显示的页码个数   |
| navigatepageNums  | List    | 是       | 页码数               |
| navigateFirstPage | Integer | 是       | 首页                 |
| navigateLastPage  | Integer | 是       | 尾页                 |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": {
      "total": 2,
      "list": [
        {
          "blogNo": "Bc7331604318223526",
          "blogCoverUrl": "http://47.107.64.157/blog/20210107/08f91604318223526.jpg",
          "blogType": "机器学习",
          "blogTagList": "[{\"name\":\"机器学习\"},{\"name\":\"深度学习\"}]",
          "blogTitle": "2_回归_案例学习",
          "blogOverview": "回归",
          "createTime": "2021-01-07T08:47:35.000+0000"
        },
        {
          "blogNo": "Bc6b01604318223526",
          "blogCoverUrl": "http://47.107.64.157/blog/20210106/d0e41604318223526.jpg",
          "blogType": "机器学习",
          "blogTagList": "[{\"name\":\"机器学习\"},{\"name\":\"深度学习\"}]",
          "blogTitle": "1_简介",
          "blogOverview": "机器学习简介",
          "createTime": "2021-01-06T09:56:56.000+0000"
        }
      ],
      "pageNum": 1,
      "pageSize": 6,
      "size": 2,
      "startRow": 1,
      "endRow": 2,
      "pages": 1,
      "prePage": 0,
      "nextPage": 0,
      "isFirstPage": true,
      "isLastPage": true,
      "hasPreviousPage": false,
      "hasNextPage": false,
      "navigatePages": 8,
      "navigatepageNums": [
        1
      ],
      "navigateFirstPage": 1,
      "navigateLastPage": 1
    }
  }
}
```







## 待添加的添加或者优化的功能

### 1、局部博客搜索  暂定

### 2、增加根据类型展示一类文章

### 3、域名 暂定

# 用户信息接口文档

## 用户登录

### 接口说明

登录验证，成功后返回用户信息

| 请求方式 | HTTP POST                            |
| -------- | ------------------------------------ |
| 接口地址 | /api/blog/login                      |
| Demo     | http://localhost:9192/api/blog/login |
| 调用方向 | 博客前端-->博客服务                  |

### 请求参数说明

| 变量名      | 类型   | 是否必须 | 说明 |
| ----------- | ------ | -------- | ---- |
| userAccount | String | 是       | 账户 |
| userPwd     | String | 是       | 密码 |

示例

```json
{
  "userAccount": "1144502582@qq.com",
  "userPwd": "123123"
}
```

### 响应参数说明

| 变量名     | 类型   | 是否必须 | 说明                                                   |
| ---------- | ------ | -------- | ------------------------------------------------------ |
| status     | int    | 是       | 响应码                                                 |
| msg        | String | 是       | 响应码说明<br />200 成功；201 账户不存在；202 密码错误 |
| result     | Object | 是       | 返回对象                                               |
| data       | Object | 是       | 包含以下字段                                           |
| userNo     | String | 是       | 用户编号                                               |
| userAvatar | String | 是       | 头像URL                                                |
| userName   | String | 是       | 用户名                                                 |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": {
      "userNo": "001",
      "userAvatar": "http://47.107.64.157/user/avatar/6fa61601560435449.jpeg",
      "userName": "0xTiefer_Atem"
    }
  }
}
```





## 查询用户信息

### 接口说明

返回用户信息

| 请求方式 | HTTP GET                                                   |
| -------- | ---------------------------------------------------------- |
| 接口地址 | /api/blog/select/user/info                                 |
| Demo     | http://localhost:9192/api/blog/select/user/info?userNo=001 |
| 调用方向 | 博客前端-->博客服务                                        |

### 请求参数说明

| 变量名 | 类型   | 是否必须 | 说明     |
| ------ | ------ | -------- | -------- |
| userNo | String | 是       | 用户编号 |

### 响应参数说明

| 变量名    | 类型   | 是否必须 | 说明         |
| --------- | ------ | -------- | ------------ |
| status | int    | 是       | 响应码       |
| msg       | String | 是       | 响应码说明   |
| result | Object | 是 | 返回对象 |
| data      | Object | 是       | 包含以下字段 |
| userNo | Object | 是       | 用户编号 |
| userAvatar | String | 是       | 头像 |
| userName | String | 是       | 昵称 |
| userMotor | String | 是       | 座右铭 |
| userRelatedLinks | String | 是 | 相关链接 |
| userSkillInfoList | String | 是 | 技能列表 |


示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": {
      "userNo": "001",
      "userAvatar": "https://avatars2.githubusercontent.com/u/41837316?s=460&u=a0defd7228d4f3553f6047340f6d68fdea8105d4&v=4",
      "userName": "0xTiefer_Atem",
      "userMotor": "Technology changes the world",
      "userRelatedLinks": "[{webLink: 'https://github.com/Ich12138',webIcon: 'https://s.cn.bing.net/th?[{\"webLink\":\"https://github.com/Ich12138',webIcon: 'https://s.cn.bing.net/th?id=AMMS_538ac5fe8754dd7df7589f49378971dc&w=39&h=39&c=7&rs=1&qlt=90&p=0&cdv=1&pid=RS\"}]",
      "userSkillInfoList": "[{\"skillName\":\"学习能力\",\"skillPercentage\":95},{\"skillName\":\"java\",\"skillPercentage\":85},{\"skillName\":\"算法\",\"skillPercentage\":50},{\"skillName\":\"vue\",\"skillPercentage\":70},{\"skillName\":\"数据结构\",\"skillPercentage\":80}]"
    }
  }
}
```



## 更新用户信息

### 接口说明

更新用户信息

| 请求方式 | HTTP POST                                       |
| -------- | ----------------------------------------------- |
| 接口地址 | /api/blog/update/user/info                      |
| Demo     | http://localhost:9192/api/blog/update/user/info |
| 调用方向 | 博客前端-->博客服务                             |

### 请求参数说明

| 变量名            | 类型   | 是否必须 | 说明     |
| ----------------- | ------ | -------- | -------- |
| userNo            | String | 是       | 用户编号 |
| userAvatar        | String | 是       | 头像URL  |
| userMotor         | String | 是       | 座右铭   |
| userName          | String | 是       | 昵称     |
| userRelatedLinks  | String | 是       | 相关链接 |
| userSkillInfoList | String | 是       | 技能列表 |

示例

```json
{
  "userAvatar": "string",
  "userMotor": "string",
  "userName": "string",
  "userNo": "002",
  "userRelatedLinks": "string",
  "userSkillInfoList": "string"
}
```



### 响应参数说明

| 变量名 | 类型    | 是否必须 | 说明         |
| ------ | ------- | -------- | ------------ |
| status | Integer | 是       | 响应码       |
| msg    | String  | 是       | 响应码说明   |
| result | Object  | 是       | 包含以下字段 |
| data   | String  | 是       | 无特殊含义   |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": null
  }
}
```



## 上传头像

### 接口说明

更新用户头像

| 请求方式 | HTTP POST                                    |
| -------- | -------------------------------------------- |
| 接口地址 | /api/blog/upload/avatar                      |
| Demo     | http://localhost:9192/api/blog/upload/avatar |
| 调用方向 | 可视化前端-->可视化服务                      |

### 请求参数说明

| 变量名 | 类型 | 是否必须 | 说明       |
| ------ | ---- | -------- | ---------- |
| file   | file | 是       | 上传的图片 |

### 响应参数说明

| 变量名 | 类型    | 是否必须 | 说明         |
| ------ | ------- | -------- | ------------ |
| status | Integer | 是       | 响应码       |
| msg    | String  | 是       | 响应码说明   |
| result | Object  | 是       | 包含以下字段 |
| data   | String  | 是       | 包含以下字段 |
| imgUrl | String  | 是       | 图片请求路径 |

示例

```json
{
  "status": 200,
  "msg": "请求成功",
  "result": {
    "data": {
      "imgUrl": "http://47.107.64.157/user/avatar/50161601559554910.jpg"
    }
  }
}
```

## 待添加或者优化的功能

### 1、界面优化

