import { HttpContext, HttpHeaders, HttpParams } from "@angular/common/http";

export interface Options{
        headers?: HttpHeaders | {
            [header: string]: string | string[];
        };
        observe?: 'body';
        context?: HttpContext;
        params?: HttpParams | {
            [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>;
        };
        reportProgress?: boolean;
        responseType?: 'json';
        withCredentials?: boolean;
        transferCache?: {
            includeHeaders?: string[];
        } | boolean;
}   

export interface Hotels
{
    items: Hotel[];
    total: number;
    page: number;
    tatalpages: number;
}

export interface Hotel
{
    idHotels: number;
    name: string;
    address: string;
    city: string;
    state: string;
    phone: string;
    email: string;
}

export interface PaginationParams
{
    [param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>;
    page: number;
    perPage: number;
}

export interface HotelImg
{
    name: string;
    imageUrl: string;
    description: string;
}

export interface User
{
    name: string;
    email: string,
    phone: string;
    password: string;
}