export class SecurityToken{
    public jwt : string = "";
    constructor(
    ){}

    public get Jwt() : string{
        return this.jwt;
    }
    
    public set Jwt(jwt : string){
        this.jwt = jwt;
    }   
 
    
}