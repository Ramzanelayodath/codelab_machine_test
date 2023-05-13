package com.example.myapplication.model


import com.google.gson.annotations.SerializedName

data class VendorDetails(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("success")
    val success: Boolean
) {
    data class Data(
        @SerializedName("Reviews")
        val reviews: List<Review>,
        @SerializedName("User_loyalty_points")
        val userLoyaltyPoints: Int,
        @SerializedName("Vendors_detail")
        val vendorsDetail: VendorsDetail,
        @SerializedName("Vendors_items")
        val vendorsItems: List<VendorsItem>
    ) {
        data class Review(
            @SerializedName("comment")
            val comment: String,
            @SerializedName("rating")
            val rating: Int,
            @SerializedName("title")
            val title: String
        )

        data class VendorsDetail(
            @SerializedName("address")
            val address: String,
            @SerializedName("area")
            val area: String,
            @SerializedName("areas")
            val areas: List<Area>,
            @SerializedName("avg_rating")
            val avgRating: String,
            @SerializedName("banner")
            val banner: String,
            @SerializedName("delivery_time")
            val deliveryTime: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("destination_id")
            val destinationId: String,
            @SerializedName("end_time")
            val endTime: String,
            @SerializedName("id")
            val id: String,
            @SerializedName("is_24")
            val is24: String,
            @SerializedName("is_busy")
            val isBusy: String,
            @SerializedName("is_open")
            val isOpen: Int,
            @SerializedName("location")
            val location: String,
            @SerializedName("logo")
            val logo: String,
            @SerializedName("min_order_amount")
            val minOrderAmount: String,
            @SerializedName("name")
            val name: String,
            @SerializedName("service_charges")
            val serviceCharges: String,
            @SerializedName("start_time")
            val startTime: String,
            @SerializedName("total_ratings")
            val totalRatings: String,
            @SerializedName("vendor_categories")
            val vendorCategories: List<String>,
            @SerializedName("vendor_policy")
            val vendorPolicy: String,
            @SerializedName("working_day")
            val workingDay: String
        ) {
            data class Area(
                @SerializedName("area_id")
                val areaId: String,
                @SerializedName("latitude")
                val latitude: String,
                @SerializedName("longitude")
                val longitude: String,
                @SerializedName("name_en")
                val nameEn: String,
                @SerializedName("vendor_area_id")
                val vendorAreaId: String
            )
        }

        data class VendorsItem(
            @SerializedName("items")
            val items: ArrayList<Item>,
            @SerializedName("vendor_category_id")
            val vendorCategoryId: Int,
            @SerializedName("vendor_category_name")
            val vendorCategoryName: String
        ) {
            data class Item(
                @SerializedName("description")
                val description: String,
                @SerializedName("duration")
                val duration: String,
                @SerializedName("icon")
                val icon: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("is_busy")
                val isBusy: Int,
                @SerializedName("is_product")
                val isProduct: Int,
                @SerializedName("name")
                val name: String,
                @SerializedName("quantity")
                val quantity: Int,
                @SerializedName("regular_price")
                val regularPrice: Int,
                @SerializedName("service_discount_price")
                val serviceDiscountPrice: Any,
                @SerializedName("service_price")
                val servicePrice: Double,
                @SerializedName("sub_item")
                val subItem: List<SubItem>,
                @SerializedName("vendor_id")
                val vendorId: String,
                @SerializedName("working_days")
                val workingDays: List<WorkingDay>
            ) {
                data class SubItem(
                    @SerializedName("addon_values")
                    val addonValues: List<AddonValue>,
                    @SerializedName("id")
                    val id: Int,
                    @SerializedName("maximum")
                    val maximum: Int,
                    @SerializedName("minimum")
                    val minimum: Int,
                    @SerializedName("name")
                    val name: String
                ) {
                    data class AddonValue(
                        @SerializedName("discount_price")
                        val discountPrice: Int,
                        @SerializedName("id")
                        val id: Int,
                        @SerializedName("name")
                        val name: String,
                        @SerializedName("price")
                        val price: Double
                    )
                }

                data class WorkingDay(
                    @SerializedName("end_time")
                    val endTime: String,
                    @SerializedName("is_24")
                    val is24: Int,
                    @SerializedName("start_time")
                    val startTime: String,
                    @SerializedName("working_day")
                    val workingDay: String
                )
            }
        }
    }
}