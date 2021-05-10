module.exports = {
    themeConfig: {
        base:'/2020-21-DAW2-M12-BookFind/',
        deploy: "npm run build && npx gh-pages docs/.vuepress/dist",
        logo: '/img/logo.png',
        sidebar: [
            {
                title: '0-Entrega',   // required
                path: '/0-Entrega/',      // optional, link of the title, which should be an absolute path and must exist
                /*collapsable: false,*/ // optional, defaults to true
                sidebarDepth: 1,    // optional, defaults to 1
                children: [ /* ... */],
            },
            {
                title: '1-Entrega',
                path: '/1-Entrega/',
                children: [ /* ... */],
                initialOpenGroupIndex: -1 // optional, defaults to 0, defines the index of initially opened subgroup
            }
        ]
    }
}