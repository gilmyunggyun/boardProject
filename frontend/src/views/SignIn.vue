<template>

    <v-sheet width="300" class="mx-auto">
        <v-form fast-fail @submit.prevent>
            <v-text-field
                    v-model="firstName"
                    label="First name"
                    :rules="firstNameRules"
            ></v-text-field>

            <v-text-field
                    v-model="lastName"
                    label="Last name"
                    :rules="lastNameRules"
            ></v-text-field>

            <v-btn type="submit" block class="mt-2">Submit</v-btn>
        </v-form>
    </v-sheet>

  <main class="mt-0 main-content main-content-bg">
    <section>
      <div class="page-header min-vh-75">
        <div class="container">
          <div class="row">
            <div class="mx-auto col-xl-4 col-lg-5 col-md-6 d-flex flex-column">
              <div class="mt-8 card card-plain">
                <div class="pb-0 card-header text-start">
                  <h3 class="font-weight-bolder text-info text-gradient">Welcome back</h3>
                  <p class="mb-0">Enter your id and password to sign in</p>
                </div>
                <div class="card-body">
                  <form
                      role="form"
                      class="text-start"
                      @submit="checkFrom"
                      method="get"
                      >
                    <label>Id</label>
                    <vsud-input type="text" placeholder="Id" name="id" isRequired="true"/>
                    <ul>
                      <li v-for="error in errors">{{ error }}</li>
                    </ul>
                    <label>Password</label>
                    <vsud-input type="password" placeholder="Password" name="password" isRequired="true" />
                    <div class="text-center">
                      <vsud-button
                        class="my-4 mb-2"
                        variant="gradient"
                        color="info"
                        full-width
                      >Sign in</vsud-button>
                    </div>
                  </form>
                </div>

              </div>
            </div>

          </div>
        </div>
      </div>
    </section>
  </main>

</template>

<script>
import { ref, reactive } from "vue";

import Navbar from "@/examples/PageLayout/Navbar.vue";
import AppFooter from "@/examples/PageLayout/Footer.vue";
import VsudInput from "@/components/VsudInput.vue";
import VsudSwitch from "@/components/VsudSwitch.vue";
import VsudButton from "@/components/VsudButton.vue";
const body = document.getElementsByTagName("body")[0];



export default {
  name: "SigninPage",
  components: {
    Navbar,
    AppFooter,
    VsudInput,
    VsudSwitch,
    VsudButton,
  },
    data: () => ({
        firstName: '',
        firstNameRules: [
            value => {
                if (value?.length > 3) return true

                return 'First name must be at least 3 characters.'
            },
        ],
        lastName: '123',
        lastNameRules: [
            value => {
                if (/[^0-9]/.test(value)) return true

                return 'Last name can not contain digits.'
            },
        ],
    }),

  setup() {
    const errors = ref("");

    const checkFrom = () => {
      errors.value = "error";
      return false;
    };
    return {
      checkFrom, errors
    };
  },
  beforeMount() {
    this.$store.state.hideConfigButton = true;
    this.$store.state.showNavbar = false;
    this.$store.state.showSidenav = false;
    this.$store.state.showFooter = false;
    body.classList.remove("bg-gray-100");
  },
  beforeUnmount() {
    this.$store.state.hideConfigButton = false;
    this.$store.state.showNavbar = true;
    this.$store.state.showSidenav = true;
    this.$store.state.showFooter = true;
    body.classList.add("bg-gray-100");
  },
};
</script>
