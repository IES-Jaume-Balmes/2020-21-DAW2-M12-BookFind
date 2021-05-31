export default {
    namespaced: true,
    state: {
        books: null,
        book: null,
        users: [
            { email: "admin@findbook.com", password: "1234", type: "admin" ,name:"admin"},
            { email: "user@findbook.com", password: "1234", type: "user",name:"user" }],
            user:null,
        userType: null,
        carrito: null
    },
    mutations: {
        setUserType(state, val) {
            if (val == 'user') state.carrito = []
            state.userType = val
        },
        setUser(state, val) {
      
            state.user = val
        },
        setCarrito(state, val) {
            let busca = false
            let posicion = null
            state.carrito.forEach((book, i) => {
                if (book.id === val.id) {
                    busca = true
                    posicion = i
                }
            });
            if (state.carrito.length > 0 && busca) {
                val.cantidad == 0 ? state.carrito.splice(posicion, 1) : state.carrito[posicion] = val
            } else {
                state.carrito.push(val)
            }
        },
        setUsersAll(state, val) {
            state.users = val
        },
        setUsers(state, val) {
            state.users.push(val);
        },
        //arranco el array de libros
        setBooks(state, val) {
            state.books = val
        },
        //añado libro a esta cosa
        setBook(state, val) {
            if (state.books) {
                state.books.push(val)
            }
        }



    }
}