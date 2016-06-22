package booklibrary

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"()
        "/"(view:"/index")
        "403"(view:'/forbidden')
        "404"(view:'/notFound')
        "500"(view:'/error')

        "/login"(controller: "auth", action: "index")

        group("/admin") {
            "/"(controller: "users")
            "/users/$action?/$id?(.$format)?"(controller: "users")
            "/users/add"(view: "/users/add")
            "/roles/add"(view: "/roles/add")
            "/roles/$action?/$id?(.$format)?"(controller: "roles")
        }
    }
}
