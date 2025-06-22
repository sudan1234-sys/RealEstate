

export interface House {
  id: number
  saved: boolean
  street: string
  city: string
  state: string
  postalCode: string
  country: string
  price: number
  type: string
  listingDate: string
  bedrooms: number
  bathrooms: number
  landSize: string
  squareFootage: number
  yearBuilt: number
  garage: number
  description: string
  photos: string[]
  features: string[]
  seller: Seller
}

export interface Seller {
  id: number
  name: string
  email: string
  phone: any
}
