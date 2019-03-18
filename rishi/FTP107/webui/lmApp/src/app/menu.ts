export class Menu {
    public qty:number=0;
    public isSelected:boolean=false;
    constructor( public foodId : number,
    public foodName: string,
    public price: number,
    public foodCat: string,
    public foodDesc: string,
    public foodCal: number,
    public vid: number ){ }
    }