export interface Land {
    id: number
    size: number
    type: string
    street: string
    city: string
    state: string
    postalCode: string
    country: string
    hasUtilities: boolean
    zoning: any
    price: number
    description: string
    landphotos: string[]
    features: string[]
    seller: Seller
  }
  
  export interface Seller {
    id: number
    name: string
    email: string
    phone: any
  }