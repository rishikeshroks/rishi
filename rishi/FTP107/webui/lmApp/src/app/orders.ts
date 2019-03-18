export class Orders {
    public isSelected: boolean;
    constructor(public oid: number,
    public custId: number,
    public venId: number,
    public foodId: number,
    public qty: number,
    public totPrice: number,
    public totCal: number,
    public ostatus: string,
    public estTime: string,
    public otime: string,
    public odate: Date,
    public oreason: string){}
}
