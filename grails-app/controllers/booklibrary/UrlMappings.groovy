package booklibrary

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"()
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')

        "/login"(controller: "auth", action: "index")

        group("/admin") {
            "/users/$action?/$id?(.$format)?"(controller: "users")
            "/users/add"(view: "/users/add")
            "/roles/$action?/$id?(.$format)?"(controller: "roles")
        }
    }
}
