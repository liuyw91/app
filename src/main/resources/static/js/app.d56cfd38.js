(function(e){function t(t){for(var r,s,i=t[0],u=t[1],c=t[2],l=0,d=[];l<i.length;l++)s=i[l],Object.prototype.hasOwnProperty.call(a,s)&&a[s]&&d.push(a[s][0]),a[s]=0;for(r in u)Object.prototype.hasOwnProperty.call(u,r)&&(e[r]=u[r]);f&&f(t);while(d.length)d.shift()();return o.push.apply(o,c||[]),n()}function n(){for(var e,t=0;t<o.length;t++){for(var n=o[t],r=!0,s=1;s<n.length;s++){var i=n[s];0!==a[i]&&(r=!1)}r&&(o.splice(t--,1),e=u(u.s=n[0]))}return e}var r={},s={app:0},a={app:0},o=[];function i(e){return u.p+"js/"+({}[e]||e)+"."+{"chunk-45670bf7":"9f60c2a5","chunk-2d0d03c8":"6e402ab8","chunk-f5db1276":"63007ba6","chunk-a3fdbb9c":"a4fb8574","chunk-4e552d82":"6bc20836","chunk-54277bc7":"6a02ba34","chunk-644e69d8":"259f4a07","chunk-2d0ba86b":"5010827f"}[e]+".js"}function u(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,u),n.l=!0,n.exports}u.e=function(e){var t=[],n={"chunk-45670bf7":1,"chunk-f5db1276":1};s[e]?t.push(s[e]):0!==s[e]&&n[e]&&t.push(s[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-45670bf7":"840f260b","chunk-2d0d03c8":"31d6cfe0","chunk-f5db1276":"e6e4ca1b","chunk-a3fdbb9c":"31d6cfe0","chunk-4e552d82":"31d6cfe0","chunk-54277bc7":"31d6cfe0","chunk-644e69d8":"31d6cfe0","chunk-2d0ba86b":"31d6cfe0"}[e]+".css",a=u.p+r,o=document.getElementsByTagName("link"),i=0;i<o.length;i++){var c=o[i],l=c.getAttribute("data-href")||c.getAttribute("href");if("stylesheet"===c.rel&&(l===r||l===a))return t()}var d=document.getElementsByTagName("style");for(i=0;i<d.length;i++){c=d[i],l=c.getAttribute("data-href");if(l===r||l===a)return t()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=t,f.onerror=function(t){var r=t&&t.target&&t.target.src||a,o=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");o.code="CSS_CHUNK_LOAD_FAILED",o.request=r,delete s[e],f.parentNode.removeChild(f),n(o)},f.href=a;var m=document.getElementsByTagName("head")[0];m.appendChild(f)})).then((function(){s[e]=0})));var r=a[e];if(0!==r)if(r)t.push(r[2]);else{var o=new Promise((function(t,n){r=a[e]=[t,n]}));t.push(r[2]=o);var c,l=document.createElement("script");l.charset="utf-8",l.timeout=120,u.nc&&l.setAttribute("nonce",u.nc),l.src=i(e);var d=new Error;c=function(t){l.onerror=l.onload=null,clearTimeout(f);var n=a[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),s=t&&t.target&&t.target.src;d.message="Loading chunk "+e+" failed.\n("+r+": "+s+")",d.name="ChunkLoadError",d.type=r,d.request=s,n[1](d)}a[e]=void 0}};var f=setTimeout((function(){c({type:"timeout",target:l})}),12e4);l.onerror=l.onload=c,document.head.appendChild(l)}return Promise.all(t)},u.m=e,u.c=r,u.d=function(e,t,n){u.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},u.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},u.t=function(e,t){if(1&t&&(e=u(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(u.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)u.d(n,r,function(t){return e[t]}.bind(null,r));return n},u.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return u.d(t,"a",t),t},u.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},u.p="/",u.oe=function(e){throw console.error(e),e};var c=window["webpackJsonp"]=window["webpackJsonp"]||[],l=c.push.bind(c);c.push=t,c=c.slice();for(var d=0;d<c.length;d++)t(c[d]);var f=l;o.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"0174":function(e,t,n){},"04c6":function(e,t,n){"use strict";var r=n("fb6b"),s=n.n(r);s.a},"25f8":function(e,t,n){"use strict";var r=n("27b7"),s=n.n(r);s.a},"27b7":function(e,t,n){},"320f":function(e,t,n){},"55b0":function(e,t,n){"use strict";var r=n("bf0d"),s=n.n(r);s.a},"55ba":function(e,t,n){"use strict";var r=n("0174"),s=n.n(r);s.a},"56d7":function(e,t,n){"use strict";n.r(t);n("e44b"),n("6648"),n("5f54"),n("f0e6");var r=n("0261"),s=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},a=[],o=n("4023"),i={},u=Object(o["a"])(i,s,a,!1,null,null,null),c=u.exports,l=(n("f548"),n("3f11")),d=n("a55b"),f=n("bb51"),m=n("8a18"),p=n("92d8");r["default"].use(l["a"]);var h=l["a"].prototype.replace;l["a"].prototype.replace=function(e){return h.call(this,e).catch((function(e){return e}))};var v=new l["a"]({routes:[{path:"/",name:"Login",component:d["default"],hidden:!0},{path:"/home",name:"Home",component:f["default"],hidden:!0,meta:{roles:["admin","user"]},children:[{path:"/chat",name:"在线聊天",component:m["default"],hidden:!0},{path:"/modifypwd",name:"修改密码",component:p["default"],hidden:!0}]}]}),g=n("ae8c"),b=n("b705"),y=n.n(b),w=n("82ae"),_=n.n(w);_.a.interceptors.response.use((function(e){if(!e.status||200!=e.status||500!=e.data.status)return e.data.msg&&b["Message"].success({message:e.data.msg}),e.data;b["Message"].error({message:e.data.msg})}),(function(e){504==e.response.status||404==e.response.status?b["Message"].error({message:"服务器被吃了( ╯□╰ )"}):403==e.response.status?b["Message"].error({message:"权限不足，请联系管理员"}):401==e.response.status?(b["Message"].error({message:"尚未登录，请登录"}),v.replace("/")):e.response.data.msg?b["Message"].error({message:e.response.data.msg}):b["Message"].error({message:"未知错误!"})}));var k="",x=function(e,t){return _()({method:"post",url:"".concat(k).concat(e),data:t,transformRequest:[function(e){var t="";for(var n in e)t+=encodeURIComponent(n)+"="+encodeURIComponent(e[n])+"&";return t}],headers:{"Content-Type":"application/x-www-form-urlencoded"}})},S=function(e,t){return _()({method:"post",url:"".concat(k).concat(e),data:t,headers:{"Content-Type":"application/json;charset=UTF-8"}})},C=function(e,t){return _()({method:"put",url:"".concat(k).concat(e),data:t})},$=function(e,t){return _()({method:"get",url:"".concat(k).concat(e),data:t})},F=function(e,t){return _()({method:"delete",url:"".concat(k).concat(e),data:t})};r["default"].use(g["a"]);new Date;var O=new g["a"].Store({state:{routes:[],sessions:{},hrs:[],currentSession:null,currentHr:JSON.parse(window.sessionStorage.getItem("user")),filterKey:"",stomp:null,isDot:{}},mutations:{INIT_CURRENTHR:function(e,t){e.currentHr=t},initRoutes:function(e,t){e.routes=t},changeCurrentSession:function(e,t){r["default"].set(e.isDot,e.currentHr.username+"#"+t.username,!1),e.currentSession=t},addMessage:function(e,t){var n=e.sessions[e.currentHr.username+"#"+t.to];n||r["default"].set(e.sessions,e.currentHr.username+"#"+t.to,[]),e.sessions[e.currentHr.username+"#"+t.to].push({content:t.content,date:new Date,self:!t.notSelf})},INIT_DATA:function(e){var t=localStorage.getItem("vue-chat-session");t&&(e.sessions=JSON.parse(t))},INIT_HR:function(e,t){e.hrs=t}},actions:{connect:function(e){},initData:function(e){e.commit("INIT_DATA"),$("/chat/hrs").then((function(t){t&&e.commit("INIT_HR",t)}))}}});O.watch((function(e){return e.sessions}),(function(e){localStorage.setItem("vue-chat-session",JSON.stringify(e))}),{deep:!0});var I=O,R=(n("6491"),n("cc57"),n("6d57"),function(e,t){t.state.routes.length>0||$("/system/config/menu").then((function(n){if(n){var r=j(n);e.addRoutes(r),t.commit("initRoutes",r),t.dispatch("connect")}}))}),j=function e(t){var r=[];return t.forEach((function(t){var s=t.path,a=t.component,o=t.name,i=t.meta,u=t.iconCls,c=t.children;c&&c instanceof Array&&(c=e(c));var l={path:s,name:o,iconCls:u,meta:i,children:c,component:function(e){a.startsWith("Home")?Promise.all([n.e("chunk-45670bf7"),n.e("chunk-f5db1276"),n.e("chunk-a3fdbb9c")]).then(function(){var t=[n("feca")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("User")?Promise.all([n.e("chunk-f5db1276"),n.e("chunk-2d0ba86b")]).then(function(){var t=[n("381a")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Per")?n.e("chunk-4e552d82").then(function(){var t=[n("ee1c")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Sal")?n.e("chunk-54277bc7").then(function(){var t=[n("d7e6")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Sta")?n.e("chunk-644e69d8").then(function(){var t=[n("0b22")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Sys")?Promise.all([n.e("chunk-45670bf7"),n.e("chunk-2d0d03c8")]).then(function(){var t=[n("66b4")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):Promise.all([n.e("chunk-45670bf7"),n.e("chunk-2d0d03c8")]).then(function(){var t=[n("66b4")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe)}};r.push(l)})),r},H=(n("508f"),n("7f22")),P=n.n(H);r["default"].prototype.$echarts=P.a,r["default"].prototype.postRequest=S,r["default"].prototype.postKeyValueRequest=x,r["default"].prototype.putRequest=C,r["default"].prototype.deleteRequest=F,r["default"].prototype.getRequest=$,r["default"].config.productionTip=!1,r["default"].use(y.a,{size:"small"}),v.beforeEach((function(e,t,n){"/"==e.path?n():window.sessionStorage.getItem("user")?(R(v,I),n()):n("/?redirect="+e.path)})),new r["default"]({router:v,store:I,render:function(e){return e(c)}}).$mount("#app")},7672:function(e,t,n){},8963:function(e,t,n){"use strict";var r=n("cb70"),s=n.n(r);s.a},"8a18":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("div",{staticClass:"sidebar"},[n("card"),n("list")],1),n("div",{staticClass:"main"},[n("message"),n("usertext")],1)])},s=[],a=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"card"}},[n("header",[n("img",{staticClass:"avatar",attrs:{src:e.user.userface,alt:e.user.name}}),n("p",{staticClass:"name"},[e._v(e._s(e.user.name))])]),n("footer",[n("input",{directives:[{name:"model",rawName:"v-model",value:e.$store.state.filterKey,expression:"$store.state.filterKey"}],staticClass:"search",attrs:{type:"text",placeholder:"search user..."},domProps:{value:e.$store.state.filterKey},on:{input:function(t){t.target.composing||e.$set(e.$store.state,"filterKey",t.target.value)}}})])])},o=[],i={name:"card",data:function(){return{user:JSON.parse(window.sessionStorage.getItem("user"))}}},u=i,c=(n("55ba"),n("4023")),l=Object(c["a"])(u,a,o,!1,null,"7ee9dd77",null),d=l.exports,f=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"list"}},[n("ul",{staticStyle:{"padding-left":"0px"}},e._l(e.hrs,(function(t){return n("li",{class:{active:!!e.currentSession&&t.username===e.currentSession.username},on:{click:function(n){return e.changeCurrentSession(t)}}},[n("img",{staticClass:"avatar",attrs:{src:t.userface,alt:t.name}}),n("el-badge",{attrs:{"is-dot":e.isDot[e.user.username+"#"+t.username]}},[n("p",{staticClass:"name"},[e._v(e._s(t.name))])])],1)})),0)])},m=[],p=n("ae8c"),h={name:"list",data:function(){return{user:JSON.parse(window.sessionStorage.getItem("user"))}},computed:Object(p["b"])(["hrs","isDot","currentSession"]),methods:{changeCurrentSession:function(e){this.$store.commit("changeCurrentSession",e)}}},v=h,g=(n("25f8"),Object(c["a"])(v,f,m,!1,null,"73709cf4",null)),b=g.exports,y=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{directives:[{name:"scroll-bottom",rawName:"v-scroll-bottom",value:e.sessions,expression:"sessions"}],attrs:{id:"message"}},[e.currentSession?n("ul",e._l(e.sessions[e.user.username+"#"+e.currentSession.username],(function(t){return n("li",[n("p",{staticClass:"time"},[n("span",[e._v(e._s(e._f("time")(t.date)))])]),n("div",{staticClass:"main",class:{self:t.self}},[n("img",{staticClass:"avatar",attrs:{src:t.self?e.user.userface:e.currentSession.userface,alt:""}}),n("p",{staticClass:"text"},[e._v(e._s(t.content))])])])})),0):e._e()])},w=[],_={name:"message",data:function(){return{user:JSON.parse(window.sessionStorage.getItem("user"))}},computed:Object(p["b"])(["sessions","currentSession"]),filters:{time:function(e){return e&&(e=new Date(e)),"".concat(e.getHours(),":").concat(e.getMinutes())}},directives:{"scroll-bottom":function(e){setTimeout((function(){e.scrollTop+=9999}),1)}}},k=_,x=(n("55b0"),Object(c["a"])(k,y,w,!1,null,"9f2df1e6",null)),S=x.exports,C=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"uesrtext"}},[n("textarea",{directives:[{name:"model",rawName:"v-model",value:e.content,expression:"content"}],attrs:{placeholder:"按 Ctrl + Enter 发送"},domProps:{value:e.content},on:{keyup:e.addMessage,input:function(t){t.target.composing||(e.content=t.target.value)}}})])},$=[],F={name:"uesrtext",data:function(){return{content:""}},computed:Object(p["b"])(["sessions","currentSession"]),methods:{addMessage:function(e){if(e.ctrlKey&&13===e.keyCode&&this.content.length){var t=new Object;t.to=this.currentSession.username,t.content=this.content,this.$store.state.stomp.send("/ws/chat",{},JSON.stringify(t)),this.$store.commit("addMessage",t),this.content=""}}}},O=F,I=(n("04c6"),Object(c["a"])(O,C,$,!1,null,"1e00b6fb",null)),R=I.exports,j={name:"FriendChat",data:function(){return{}},mounted:function(){this.$store.dispatch("initData")},components:{card:d,list:b,message:S,usertext:R}},H=j,P=(n("8963"),Object(c["a"])(H,r,s,!1,null,"2e08323c",null));t["default"]=P.exports},"92d8":function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return e.hr?n("div",[n("el-card",{staticClass:"box-card",staticStyle:{width:"400px"}},[n("div",{staticClass:"clearfix",attrs:{slot:"header"},slot:"header"},[n("span",[e._v(e._s(e.hr.name))])]),n("div",[n("div",{staticStyle:{display:"flex","justify-content":"center"}},[n("el-upload",{attrs:{"show-file-list":!1,"on-success":e.onSuccess,data:e.hr,action:"/hr/userface"}},[n("img",{staticStyle:{width:"100px",height:"100px","border-radius":"50px"},attrs:{title:"点击修改用户图像",src:e.hr.userface,alt:""}})])],1),n("div",[e._v("电话号码：\n                  "),n("el-tag",[e._v(e._s(e.hr.telephone))])],1),n("div",[e._v("手机号码：\n                  "),n("el-tag",[e._v(e._s(e.hr.phone))])],1),n("div",[e._v("居住地址：\n                  "),n("el-tag",[e._v(e._s(e.hr.address))])],1),n("div",[e._v("用户标签：\n                  "),e._l(e.hr.roles,(function(t,r){return n("el-tag",{key:r,staticStyle:{"margin-right":"5px"},attrs:{type:"success"}},[e._v("\n                      "+e._s(t.nameZh)+"\n                  ")])}))],2),n("div",{staticStyle:{display:"flex","justify-content":"space-around","margin-top":"10px"}},[n("el-button",{attrs:{type:"primary"},on:{click:e.showUpdateHrInfoView}},[e._v("修改信息")]),n("el-button",{attrs:{type:"danger"},on:{click:e.showUpdatePasswdView}},[e._v("修改密码")])],1)])]),n("el-dialog",{attrs:{title:"修改用户信息",visible:e.dialogVisible,width:"30%"},on:{"update:visible":function(t){e.dialogVisible=t}}},[n("div",[n("table",[n("tr",[n("td",[n("el-tag",[e._v("用户昵称：")])],1),n("td",[n("el-input",{model:{value:e.hr2.name,callback:function(t){e.$set(e.hr2,"name",t)},expression:"hr2.name"}})],1)]),n("tr",[n("td",[n("el-tag",[e._v("电话号码：")])],1),n("td",[n("el-input",{model:{value:e.hr2.telephone,callback:function(t){e.$set(e.hr2,"telephone",t)},expression:"hr2.telephone"}})],1)]),n("tr",[n("td",[n("el-tag",[e._v("手机号码：")])],1),n("td",[n("el-input",{model:{value:e.hr2.phone,callback:function(t){e.$set(e.hr2,"phone",t)},expression:"hr2.phone"}})],1)]),n("tr",[n("td",[n("el-tag",[e._v("用户地址：")])],1),n("td",[n("el-input",{model:{value:e.hr2.address,callback:function(t){e.$set(e.hr2,"address",t)},expression:"hr2.address"}})],1)])])]),n("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[n("el-button",{on:{click:function(t){e.dialogVisible=!1}}},[e._v("取 消")]),n("el-button",{attrs:{type:"primary"},on:{click:e.updateHrInfo}},[e._v("确 定")])],1)]),n("el-dialog",{attrs:{title:"修改密码",visible:e.passwdDialogVisible,width:"30%"},on:{"update:visible":function(t){e.passwdDialogVisible=t}}},[n("div",[n("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,"status-icon":"",rules:e.rules,"label-width":"100px"}},[n("el-form-item",{attrs:{label:"请输入旧密码",prop:"oldpass"}},[n("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:e.ruleForm.oldpass,callback:function(t){e.$set(e.ruleForm,"oldpass",t)},expression:"ruleForm.oldpass"}})],1),n("el-form-item",{attrs:{label:"请输入新密码",prop:"pass"}},[n("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:e.ruleForm.pass,callback:function(t){e.$set(e.ruleForm,"pass",t)},expression:"ruleForm.pass"}})],1),n("el-form-item",{attrs:{label:"新确认密码",prop:"checkPass"}},[n("el-input",{attrs:{type:"password",autocomplete:"off"},model:{value:e.ruleForm.checkPass,callback:function(t){e.$set(e.ruleForm,"checkPass",t)},expression:"ruleForm.checkPass"}})],1),n("el-form-item",[n("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("提交")]),n("el-button",{on:{click:function(t){return e.resetForm("ruleForm")}}},[e._v("重置")])],1)],1)],1)])],1):e._e()},s=[],a=(n("f548"),{name:"HrInfo",data:function(){var e=this,t=function(t,n,r){""===n?r(new Error("请输入密码")):(""!==e.ruleForm.checkPass&&e.$refs.ruleForm.validateField("checkPass"),r())},n=function(t,n,r){""===n?r(new Error("请再次输入密码")):n!==e.ruleForm.pass?r(new Error("两次输入密码不一致!")):r()};return{ruleForm:{oldpass:"",pass:"",checkPass:""},rules:{oldpass:[{validator:t,trigger:"blur"}],pass:[{validator:t,trigger:"blur"}],checkPass:[{validator:n,trigger:"blur"}]},hr:null,hr2:null,dialogVisible:!1,passwdDialogVisible:!1}},mounted:function(){this.initHr()},methods:{onSuccess:function(){this.initHr()},updateHrInfo:function(){var e=this;this.putRequest("/hr/info",this.hr2).then((function(t){t&&(e.dialogVisible=!1,e.initHr())}))},showUpdateHrInfoView:function(){this.dialogVisible=!0},submitForm:function(e){var t=this;this.$refs[e].validate((function(e){if(!e)return!1;t.ruleForm.hrid=t.hr.id,t.putRequest("/hr/pass",t.ruleForm).then((function(e){e&&(t.getRequest("/logout"),window.sessionStorage.removeItem("user"),t.$store.commit("initRoutes",[]),t.$router.replace("/"))}))}))},resetForm:function(e){this.$refs[e].resetFields()},showUpdatePasswdView:function(){this.passwdDialogVisible=!0},initHr:function(){var e=this;this.getRequest("/hr/info").then((function(t){t&&(e.hr=t,e.hr2=Object.assign({},e.hr),window.sessionStorage.setItem("user",JSON.stringify(t)),e.$store.commit("INIT_CURRENTHR",t))}))}}}),o=a,i=n("4023"),u=Object(i["a"])(o,r,s,!1,null,"477e2013",null);t["default"]=u.exports},a55b:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-form",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],ref:"loginForm",staticClass:"loginContainer",attrs:{rules:e.rules,"element-loading-text":"正在登录...","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",model:e.loginForm}},[n("h3",{staticClass:"loginTitle"},[e._v("系统登录")]),n("el-form-item",{attrs:{prop:"username"}},[n("el-input",{attrs:{size:"normal",type:"text","auto-complete":"off",placeholder:"请输入用户名"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),n("el-form-item",{attrs:{prop:"password"}},[n("el-input",{attrs:{size:"normal",type:"password","auto-complete":"off",placeholder:"请输入密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),n("el-form-item",{attrs:{prop:"code"}},[n("el-input",{staticStyle:{width:"250px"},attrs:{size:"normal",type:"text","auto-complete":"off",placeholder:"点击图片更换验证码"},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.submitLogin(t)}},model:{value:e.loginForm.code,callback:function(t){e.$set(e.loginForm,"code",t)},expression:"loginForm.code"}}),n("img",{attrs:{src:e.vcUrl,alt:""},on:{click:e.updateVerifyCode}})],1),n("el-button",{attrs:{size:"normal",type:"primary",id:"yunmiClass"},on:{click:e.submitLogin}},[e._v("登录")])],1)],1)},s=[],a=(n("f548"),{name:"Login",data:function(){return{loading:!1,vcUrl:"/verifyCode?time="+new Date,loginForm:{username:"admin",password:"123",code:""},checked:!0,rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}],code:[{required:!0,message:"请输入验证码",trigger:"blur"}]}}},methods:{updateVerifyCode:function(){this.vcUrl="/verifyCode?time="+new Date},submitLogin:function(){var e=this;this.$refs.loginForm.validate((function(t){if(!t)return!1;e.loading=!0,e.postKeyValueRequest("/doLogin",e.loginForm).then((function(t){if(e.loading=!1,t){e.$store.commit("INIT_CURRENTHR",t.data),window.sessionStorage.setItem("user",JSON.stringify(t.data));var n=e.$route.query.redirect;e.$router.replace("/"==n||void 0==n?"/home":n)}else e.vcUrl="/verifyCode?time="+new Date}))}))}}}),o=a,i=(n("d6db"),n("4023")),u=Object(i["a"])(o,r,s,!1,null,null,null);t["default"]=u.exports},a83d:function(e,t,n){},b640:function(e,t,n){e.exports=n.p+"img/logo.b7841d30.jpg"},bb51:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{attrs:{id:"app"}},[r("el-container",[r("el-header",{staticClass:"homeHeader"},[r("div",{staticClass:"title"},[e._v("云觅")]),r("div",[r("el-dropdown",{staticClass:"userInfo",on:{command:e.commandHandler}},[r("span",{staticClass:"el-dropdown-link"},[e._v("\n                        "+e._s(e.user.name)),r("i",[r("img",{attrs:{src:n("b640"),alt:""}})])]),r("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[r("el-dropdown-item",{attrs:{command:"userinfo"}},[e._v("个人中心")]),r("el-dropdown-item",{attrs:{command:"logout",divided:""}},[e._v("注销登录")])],1)],1)],1)]),r("el-container",[r("el-aside",{attrs:{width:"250px"}},[r("el-menu",{attrs:{router:"","unique-opened":""}},e._l(e.routes,(function(t,n){return t.hidden?e._e():r("el-submenu",{key:n,attrs:{index:n+""}},[r("template",{slot:"title"},[r("i",{class:t.iconCls,staticStyle:{"margin-right":"5px"}}),r("span",[e._v(e._s(t.name))])]),e._l(t.children,(function(t,n){return r("el-menu-item",{key:n,attrs:{index:t.path}},[e._v("\n                            "+e._s(t.name)+"\n                        ")])}))],2)})),1)],1),r("el-container",[r("el-main",["/home"!=this.$router.currentRoute.path?r("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[r("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),r("el-breadcrumb-item",[e._v(e._s(this.$router.currentRoute.name))])],1):e._e(),"/home"==this.$router.currentRoute.path?r("div",{staticClass:"homeWelcome"},[e._v("\n                        欢迎来到云觅APP后台管理系统！\n                    ")]):e._e(),r("router-view",{staticClass:"homeRouterView"})],1),r("el-footer")],1)],1)],1)],1)},s=[],a=(n("f548"),n("a83d"),{name:"Home",data:function(){return{}},computed:{routes:function(){return this.$store.state.routes},user:function(){return this.$store.state.currentHr}},methods:{goChat:function(){this.$router.push("/chat")},commandHandler:function(e){var t=this;"logout"==e?this.$confirm("此操作将注销登录, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.getRequest("/logout"),window.sessionStorage.removeItem("user"),t.$store.commit("initRoutes",[]),t.$router.replace("/")})).catch((function(){t.$message({type:"info",message:"已取消操作"})})):"userinfo"==e&&this.$router.push("/hrinfo")}}}),o=a,i=(n("cccb"),n("4023")),u=Object(i["a"])(o,r,s,!1,null,null,null);t["default"]=u.exports},bf0d:function(e,t,n){},cb70:function(e,t,n){},cccb:function(e,t,n){"use strict";var r=n("320f"),s=n.n(r);s.a},d6db:function(e,t,n){"use strict";var r=n("7672"),s=n.n(r);s.a},fb6b:function(e,t,n){}});
//# sourceMappingURL=app.d56cfd38.js.map