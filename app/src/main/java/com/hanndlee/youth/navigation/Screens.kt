package com.hanndlee.youth.navigation

sealed class Screens(val route: String) {

    // un-authenticated
    object Onboarding : Screens("onboarding")
    object Login : Screens("login")
    object SignUp : Screens("signUp")
    object ForgotPassword : Screens("forgotPassword")
    object ResetPassword : Screens("resetPassword")
    object VerifyEmail : Screens("verifyEmail")


    // authenticated
    object Home : Screens("home")
    object Detail : Screens("detail")
    object Product : Screens("product")

    // bottom navigation







}