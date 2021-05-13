rootProject.name = "movies-mircroservices"
include("utils")
include("utils:data-loader")
findProject(":utils:data-loader")?.name = "data-loader"
include("utils:communication")
findProject(":utils:communication")?.name = "communication"
include("utils:authentification")
findProject(":utils:authentification")?.name = "authentification"
include("utils:tenants")
findProject(":utils:tenants")?.name = "tenants"
include("internal")
include("internal:gateway")
findProject(":internal:gateway")?.name = "gateway"
include("internal:config-service")
findProject(":internal:config-service")?.name = "config-service"
include("internal:discovery-service")
findProject(":internal:discovery-service")?.name = "discovery-service"
include("services")
include("services:email-service")
findProject(":services:email-service")?.name = "email-service"
include("services:image-service")
findProject(":services:image-service")?.name = "image-service"
include("services:movie-service")
findProject(":services:movie-service")?.name = "movie-service"
include("services:recommendation-service")
findProject(":services:recommendation-service")?.name = "recommendation-service"
include("services:statistics-service")
findProject(":services:statistics-service")?.name = "statistics-service"
include("services:suggestion-service")
findProject(":services:suggestion-service")?.name = "suggestion-service"
include("services:users-service")
findProject(":services:users-service")?.name = "users-service"
include("core")
include("core:domain")
findProject(":core:domain")?.name = "domain"
